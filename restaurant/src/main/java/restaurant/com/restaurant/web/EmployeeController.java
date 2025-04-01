package restaurant.com.restaurant.web;

import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.employee.model.EmployeeType;
import restaurant.com.restaurant.employee.service.EmployeeService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private RestaurantService restaurantService;

    public EmployeeController(EmployeeService employeeService, RestaurantService restaurantService) {
        this.employeeService = employeeService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/panel")
    public ModelAndView employeePanel(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
        Employee employee = employeeService.getEmployeeByUserId(authenticatedUser.getEmail());
        Long restaurantId = employee.getRestaurant().getId();
        ModelAndView modelAndView = new ModelAndView();
        String view = resolveTemplate(employee.getEmployeeType());
        modelAndView.setViewName(view);
        modelAndView.addObject("restaurantId", restaurantId);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getEmployees(@RequestParam(required = false) Long restaurantId) {
        List<Employee> employees = null;
        if (restaurantId != null) {
            employees = employeeService.getAllEmployeesByRestaurantId(restaurantId);
        } else {
            employees = employeeService.getAllEmployees();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/employees");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createEmployee(@Valid CreateEmployeeRequest createEmployeeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("employee/employee-create");
        }
        employeeService.createEmployee(createEmployeeRequest);
        return new ModelAndView("redirect:/employees");
    }

    @GetMapping("/create")
    public ModelAndView createEmployee() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/employee-create");
        modelAndView.addObject("createEmployeeRequest", new CreateEmployeeRequest());
        modelAndView.addObject("restaurants", restaurants);
        return modelAndView;
    }

    @GetMapping("/{employeeId}")
    public ModelAndView getEmployee(@PathVariable UUID employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/employee-view");
        modelAndView.addObject("employee", employee);

        return modelAndView;
    }

    private static String resolveTemplate(EmployeeType type) {
        return switch (type) {
            case MANAGER -> "employee/manager-panel";
            case WAITER -> "employee/waiter-panel";
            default -> throw new IllegalStateException("Unsupported employee type: " + type);
        };
    }
}
