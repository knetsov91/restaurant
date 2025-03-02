package restaurant.com.restaurant.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import restaurant.com.restaurant.order.model.UserRole;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.repository.UserRepository;
import restaurant.com.restaurant.web.dto.RegisterRequest;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

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
            throw new RuntimeException("Something went wrong");
        }

        if (!registerRequest.getPassword().equals(registerRequest.getPasswordConfirmation())) {
            throw new RuntimeException("Something went wrong");
        }

        User user = User.builder()
                .role(UserRole.USER)
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .createdOn(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }
}
