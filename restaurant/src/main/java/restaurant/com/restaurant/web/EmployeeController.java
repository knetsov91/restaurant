package restaurant.com.restaurant.web;

import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.employee.service.EmployeeService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private RestaurantService restaurantService;

    public EmployeeController(EmployeeService employeeService, RestaurantService restaurantService) {
        this.employeeService = employeeService;
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ModelAndView getEmployees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employees");


        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createEmployee() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee-create");
        modelAndView.addObject("createEmployeeRequest", new CreateEmployeeRequest());
        modelAndView.addObject("restaurants", restaurants);
        return modelAndView;
    }

}
