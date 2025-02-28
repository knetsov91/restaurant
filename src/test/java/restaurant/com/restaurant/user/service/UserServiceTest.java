package restaurant.com.restaurant.user.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurant.com.restaurant.web.dto.RegisterRequest;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(null, null);
    }
    @Test
    void test_whenPasswordAndConfirmPasswordDontMatch_thenThrowException() {

        RegisterRequest registerRequest =new RegisterRequest("password", "confirmPassword");
        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.register(registerRequest);
        });
    }
}