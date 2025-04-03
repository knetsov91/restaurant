package restaurant.com.restaurant.user.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import restaurant.com.restaurant.customer.service.CustomerService;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.model.UserRole;
import restaurant.com.restaurant.user.repository.UserRepository;
import restaurant.com.restaurant.web.dto.RegisterRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceUTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private CustomerService customerService;

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

    @Test
    void test_whenUserInfoIsCorrect_thenRegisterUser() {
        String password = "password";
        String hashedPassword = "!@#$%^&*(";
        String email = "email@email.com";
        LocalDateTime createdOn = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

        RegisterRequest register = RegisterRequest.builder()
                .email(email)
                .password(password)
                .passwordConfirmation(password)
                .build();

        User user = User.builder()
                .role(UserRole.CUSTOMER)
                .email(email)
                .password(hashedPassword)
                .createdOn(createdOn)
                .isActive(true)
                .build();

        Mockito.when(passwordEncoder.encode(register.getPassword())).thenReturn(hashedPassword);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Mockito.when(userRepository.count()).thenReturn(1L);

        Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        userService.register(register);

        assertEquals(1L, userRepository.count());
        assertEquals(hashedPassword, user.getPassword());
        Assertions.assertTrue(user.isActive());
        assertEquals(email, user.getEmail());
    }

    @Test
    void givenExistingUserEmail_whenFindUserByEmail_thenReturnUser() {
        String email = "email@email.com";
        User user = User
                .builder()
                .email(email)
                .password("password")
                .build();

        Mockito.when(userRepository.findByEmail(email))
                .thenReturn(Optional.of(user));

        User u = userService.findUserByEmail(email);

        assertEquals(user.getEmail(), u.getEmail());

    }

    @Test
    void whenFindUserByEmail_thenReturnAllUser() {
        String email = "email@email.com";
        User user = User
                .builder()
                .email(email)
                .password("password")
                .build();

        List<User> users = List.of(new User());
        Mockito.when(userRepository.findAll())
                .thenReturn(users);

        List<User> users1 = userService.getAllUsers();

        assertEquals(users.size(), users1.size());

    }

}