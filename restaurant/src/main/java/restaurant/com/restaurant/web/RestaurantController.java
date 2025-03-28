package restaurant.com.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.repository.RestaurantRepository;
import restaurant.com.restaurant.restaurant.service.RestaurantService;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ModelAndView getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurants");
        modelAndView.addObject("restaurants", restaurants);

        return modelAndView;
    }
}
