package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import restaurant.com.restaurant.reservation.service.ReservationService;
import java.time.LocalDateTime;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
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
}