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
import restaurant.com.restaurant.reservation.model.Reservation;
import restaurant.com.restaurant.reservation.model.ReservationStatus;
import restaurant.com.restaurant.reservation.service.ReservationService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReservationController.class)
class ReservationControllerApiTest {

    @MockitoBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void postRequestToCreateReservationEndpoint_shouldCreateReservationAndRedirect() throws Exception {

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/reservations")
                .formField("customersNumber", "1")
                .formField("reservationDate", LocalDateTime.now().toString())
                .formField("phoneNumber", "1111111111")
                .with(csrf());

        mockMvc.perform(req)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    void postRequestToCreateReservationEndpointWithInvalidData_shouldRenderReservationCreationView() throws Exception {

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/reservations")
                .formField("customersNumber", "")
                .formField("reservationDate", LocalDateTime.now().toString())
                .formField("phoneNumber", "1111111111")
                .with(csrf());

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("reservation/reservation-create"));
    }

    @Test
    void getAuthenticatedRequestAllReservationsEndpointWithInvalidData_shouldRenderReservationsView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/reservations")
                .with(user(authenticatedUser));

        when(reservationService.getReservationsByClientId(any())).thenReturn(List.of(new Reservation()));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("reservation/reservations"))
                .andExpect(model().attributeExists("reservations"));
    }

    @Test
    void getAuthenticatedRequestToCustomerReservationsEndpointWithInvalidData_shouldRenderReservationsView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/reservations/customers/{customerId}", UUID.randomUUID())
                .with(user(authenticatedUser));

        Restaurant restaurant = TestBuilder.createRestaurant();
        Reservation res = new Reservation();
        res.setReservationStatus(ReservationStatus.RESERVED);
        res.setCustomersNumber(1);
        res.setPhoneNumber("1111111111");
        res.setRestaurant(restaurant);

        when(reservationService.getReservationsByClientId(any())).thenReturn(List.of(res));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("customer/reservations"))
                .andExpect(model().attributeExists("reservations"));
    }
}