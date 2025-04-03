package restaurant.com.restaurant.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.customer.service.CustomerService;
import restaurant.com.restaurant.exception.RegisterException;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.model.UserRole;
import restaurant.com.restaurant.user.repository.UserRepository;
import restaurant.com.restaurant.web.AuthenticationController;
import restaurant.com.restaurant.web.dto.CreateUserRequest;
import restaurant.com.restaurant.web.dto.RegisterRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private CustomerService customerService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, CustomerService customerService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.customerService = customerService;
    }

    public void register(RegisterRequest registerRequest) {
        Optional<User> byEmail = userRepository.findByEmail(registerRequest.getEmail());

        if (byEmail.isPresent()) {
            LOGGER.error("Email already in use");
            throw new RegisterException("Something went wrong");
        }

        if (!registerRequest.getPassword().equals(registerRequest.getPasswordConfirmation())) {
            LOGGER.error("Passwords do not match");
            throw new RegisterException("Something went wrong");
        }

        User user = User.builder()
                .role(UserRole.CUSTOMER)
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .createdOn(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .isActive(true)
                .build();

        User savedUser = userRepository.save(user);
        customerService.createCustomer(savedUser);

        LOGGER.info("User registered successfully");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user.getEmail(), user.getPassword(), user.isActive(), user.getRole(), user.getId());

        return authenticatedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(CreateUserRequest createUserRequest) {
        User user = User.builder()
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .build();
        user.setRole(createUserRequest.getRole());
        user.setCreatedOn(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        user.setPasswordChanged(false);
        user.setActive(true);
        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public void changerRole(String email, UserRole role) {
        User userByEmail = findUserByEmail(email);
        userByEmail.setRole(role);

        userRepository.save(userByEmail);
    }
}