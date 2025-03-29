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
import restaurant.com.restaurant.exception.RegisterException;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.model.UserRole;
import restaurant.com.restaurant.user.repository.UserRepository;
import restaurant.com.restaurant.web.AuthenticationController;
import restaurant.com.restaurant.web.dto.LoginRequest;
import restaurant.com.restaurant.web.dto.RegisterRequest;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
                .role(UserRole.CLIENT)
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .createdOn(LocalDateTime.now())
                .build();

        userRepository.save(user);
        LOGGER.info("User registered successfully");
    }

    public User login(LoginRequest loginRequest) {

        Optional<User> byEmail = userRepository.findByEmail(loginRequest.getEmail());

        if (byEmail.isEmpty()) {
            throw new RuntimeException("Something went wrong");
        }

        User user = byEmail.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Something went wrong");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user.getEmail(), user.getPassword(), user.isActive(), user.getRole());

        return authenticatedUser;
    }
}
