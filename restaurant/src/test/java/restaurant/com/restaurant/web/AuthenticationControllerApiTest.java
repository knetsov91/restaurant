package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import restaurant.com.restaurant.user.service.UserService;
import restaurant.com.restaurant.web.dto.RegisterRequest;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(AuthenticationController.class)
class AuthenticationControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;


    @Test
    void testRegistration_whenUserExists_thenThrowsException() throws Exception {
        String email = "test@test.com";
        RegisterRequest build = RegisterRequest.builder().email(email)
                .password("password")
                .passwordConfirmation("password")
                .build();

        MvcResult mvcResult = mockMvc.perform(
                post("/register")
                        .param("email", email)
                        .param("password", "password")
                        .param("passwordConfirmation", "password")
                        .with(csrf())
        ).andExpect(status().is3xxRedirection()).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

    }
    @Test
    void getRequestToRegisterEndpoint_shouldReturnRegisterView() throws Exception {

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/register");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }
}