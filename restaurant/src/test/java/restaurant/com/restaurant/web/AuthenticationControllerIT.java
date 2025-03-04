package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.exception.RegisterException;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.repository.UserRepository;
import restaurant.com.restaurant.user.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private final UserRepository userRepository;

    @Autowired
    AuthenticationControllerIT(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void testRegistration_whenUserExists_thenThrowException() throws Exception {
        String email = "test@test.com";

        Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(new User()));
        mockMvc.perform(post("/register")
                .param("email", email)
                .param("password", "password")
                .param("passwordConfirmation", "password"))
                .andExpect(status().is5xxServerError())
                .andExpect( res -> Assertions.assertTrue(res.getResolvedException() instanceof RegisterException));

    }


    @Test
    void testRegister_whenSuccessfullyRegistered_thenRedirect() throws Exception {
        String email = "test@test.com";
        Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(User.builder().email(email).build()));
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new User());
        mockMvc.perform(post("/register")
                .param("email", email)
                .param("password", "password")
                .param("passwordConfirmation", "password"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void testRegister_whenPasswordsDontMatch_thenThrowException() throws Exception {

        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());

        MvcResult mvcResult = mockMvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .formField()
                .param("email", "email@exmaple.com")
                .param("password", "pas")
                .param("confirmPassword", "pass125")
        ).andExpect(status().is(200))
//                .andExpect(view().name("register"))
                .andReturn();

        String redirectedUrl = mvcResult.getResponse().getRedirectedUrl();


        Exception resolvedException = mvcResult.getResolvedException();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        assertEquals(contentAsString, "Something went wrong");
    }
}