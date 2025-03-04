package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import restaurant.com.restaurant.exception.RegisterException;
import restaurant.com.restaurant.user.service.UserService;
import restaurant.com.restaurant.web.dto.RegisterRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticationController.class)
//@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Autowired
    AuthenticationControllerTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void testRegistration_whenUserExists_thenThrowsException() throws Exception {
        String email = "test@test.com";
        RegisterRequest build = RegisterRequest.builder().email(email)
                .password("password")
                .passwordConfirmation("password")
                .build();
        doThrow(RegisterException.class).when(userService).register(build);

        MvcResult mvcResult = mockMvc.perform(
                post("/register")
                        .param("email", email)
                        .param("password", "password")
                        .param("passwordConfirmation", "password")
        ).andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

    }

}