package restaurant.com.restaurant.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.user.model.UserRole;
import java.util.List;

@Controller
public class IndexController {

    private final RestaurantService restaurantService;

    public IndexController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ModelAndView index() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("restaurants", restaurants);

        return modelAndView;
    }

    @GetMapping("/panel")
    public String resolve(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
        UserRole userRole = authenticatedUser.getUserRole();

        String view = renderView(userRole);
        return view;
    }

    private static String renderView(UserRole role) {
        switch (role) {
            case ADMIN:
                return "admin-panel";
            case OWNER:
                return "owner-panel";
            case EMPLOYEE:
                return "redirect:/employees/panel";
            default:
                return "redirect:/home";
        }
    }
}
