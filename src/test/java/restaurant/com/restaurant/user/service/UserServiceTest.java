package restaurant.com.restaurant.user.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.repository.UserRepository;
import restaurant.com.restaurant.web.dto.RegisterRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, null);
    }
    @Test
    void test_whenPasswordAndConfirmPasswordDontMatch_thenThrowException() {

        RegisterRequest registerRequest =RegisterRequest.builder()
                .password("password")
                .passwordConfirmation("confirmPassword")
                .build();
        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.register(registerRequest);
        });
    }

    @Test
    void test_whenUserExists_thenThrowException() {
        String email = "email@email.com";
        Mockito.when(userRepository.findByEmail(email))
                .thenReturn(Optional
                    .of(User
                        .builder()
                        .email(email)
                        .password("password")
                        .build()));

        Optional<User> byEmail = userRepository.findByEmail(email);
        Assertions.assertTrue(byEmail.isPresent());

        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.register(RegisterRequest
                        .builder()
                        .email(email)
                        .password("password")
                        .build());
        });
    }
}