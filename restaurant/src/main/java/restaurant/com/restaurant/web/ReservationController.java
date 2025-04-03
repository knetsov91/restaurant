package restaurant.com.restaurant.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.reservation.model.Reservation;
import restaurant.com.restaurant.reservation.model.ReservationStatus;
import restaurant.com.restaurant.reservation.service.ReservationService;
import restaurant.com.restaurant.web.dto.CreateReservationRequest;
import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ModelAndView getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reservation/reservations");
        modelAndView.addObject("reservations", reservations);

        return modelAndView;
    }

    @GetMapping("/customers/{customerId}")
    public ModelAndView getReservationById(@PathVariable UUID customerId) {
        List<Reservation> reservationsByClientId = reservationService.getReservationsByClientId(customerId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/reservations");
        modelAndView.addObject("reservations", reservationsByClientId);

        return modelAndView;
    }

    @PutMapping("/{reservationId}/status")
    public String changeReservationStatus(@PathVariable UUID reservationId,
                                          @RequestParam ReservationStatus reservationStatus,
                                          @RequestParam Long restaurantId
    ) {
        reservationService.changeReservationStatus(reservationId, reservationStatus);

        return "redirect:/restaurants/" + restaurantId + "/reservations";
    }
}