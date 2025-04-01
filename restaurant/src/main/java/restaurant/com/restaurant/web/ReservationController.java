package restaurant.com.restaurant.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.reservation.service.ReservationService;
import restaurant.com.restaurant.web.dto.CreateReservationRequest;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ModelAndView createReservation(@Valid CreateReservationRequest createReservationRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("reservation/reservation-create");
        }
        reservationService.createReservation(createReservationRequest);
        return new ModelAndView("redirect:/");
    }
}