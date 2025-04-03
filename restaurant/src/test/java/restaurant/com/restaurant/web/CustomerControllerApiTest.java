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
import restaurant.com.restaurant.customer.model.Customer;
import restaurant.com.restaurant.customer.service.CustomerService;
import restaurant.com.restaurant.reservation.service.ReservationService;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerApiTest {

    @MockitoBean
    private ReservationService reservationService;

    @MockitoBean
    private CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAuthenticatedRequestToCustomerHomeEndpoint_shouldRenderCustomerHomeView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();

        Customer customer = new Customer();
        customer.setId(authenticatedUser.getUserId());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/home")
                .with(user(authenticatedUser));
        when(customerService.getCustomerByUserId(authenticatedUser.getUserId())).thenReturn(customer);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customerId"))
                .andExpect(view().name("home"));

    }
}