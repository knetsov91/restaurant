package restaurant.com.restaurant.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.customer.model.Customer;
import restaurant.com.restaurant.customer.service.CustomerService;
import restaurant.com.restaurant.reservation.service.ReservationService;

@Controller
public class CustomerController {

    private ReservationService reservationService;
    private CustomerService customerService;

    public CustomerController(ReservationService reservationService, CustomerService customerService) {
        this.reservationService = reservationService;
        this.customerService = customerService;
    }

    @GetMapping("/home")
    public ModelAndView home(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
        Customer customerByUserId = customerService.getCustomerByUserId(authenticatedUser.getUserId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customerId", customerByUserId.getId());
        modelAndView.setViewName("home");

        return modelAndView;
    }
}