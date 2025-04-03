package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import restaurant.com.restaurant.TestBuilder;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.user.model.UserRole;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(IndexController.class)
class IndexControllerApiTest {

    @MockitoBean
    private  RestaurantService restaurantService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRequestToIndexEndpoint_shouldReturnIndexPage() throws Exception {
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/");

        when(restaurantService.getRestaurants())
                .thenReturn(List.of(new Restaurant()));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("restaurants"));
    }

    @Test
    void getAuthenticatedRequestForAdminToPanelEndpoint_shouldRenderAdminPanel() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        authenticatedUser.setUserRole(UserRole.ADMIN);

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/panel")
                .with(user(authenticatedUser));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("admin-panel"));

    }

    @Test
    void getAuthenticatedRequestForCustomerToPanelEndpoint_shouldRedirectToCustomerPanel() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        authenticatedUser.setUserRole(UserRole.CUSTOMER);

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/panel")
                .with(user(authenticatedUser));

        mockMvc.perform(req)
                .andExpect(status().is3xxRedirection());

    }
}