package restaurant.com.restaurant.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.employee.service.EmployeeService;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.service.MenuService;
import restaurant.com.restaurant.order.client.dto.OrderResponse;
import restaurant.com.restaurant.order.service.OrderService;
import restaurant.com.restaurant.reservation.model.Reservation;
import restaurant.com.restaurant.reservation.service.ReservationService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateReservationRequest;
import restaurant.com.restaurant.web.dto.CreateRestaurantRequest;
import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;
    private EmployeeService employeeService;
    private MenuService menuService;
    private ReservationService reservationService;
    private OrderService orderService;

    public RestaurantController(RestaurantService restaurantService, EmployeeService employeeService, MenuService menuService, ReservationService reservationService, OrderService orderService) {
        this.restaurantService = restaurantService;
        this.employeeService = employeeService;
        this.menuService = menuService;
        this.reservationService = reservationService;
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/restaurants");
        modelAndView.addObject("restaurants", restaurants);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView addRestaurant(@Valid CreateRestaurantRequest createRestaurantRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("restaurant/restaurant-create");
        }
        restaurantService.createRestaurant(createRestaurantRequest);

        return new ModelAndView("redirect:/restaurants");
    }

    @GetMapping("/{restaurantId}/menus")
    public ModelAndView getAllRestaurantMenus(@PathVariable(name = "restaurantId") Long restaurantId) {
        List<Menu> menus = restaurantService.getRestaurantMenus(restaurantId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menus", menus);
        modelAndView.addObject("restaurantId", restaurantId);
        modelAndView.setViewName("restaurant/restaurant-menus");

        return modelAndView;
    }

    @GetMapping("/{restaurantId}/employees")
    public ModelAndView getEmployees(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);

        List<Employee> employees =  restaurantService.getRestaurantEmployees(restaurantId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/restaurant-employees");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("restaurantName", restaurant.getName());

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView addRestaurant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/restaurant-create");
        modelAndView.addObject("createRestaurantRequest", new CreateRestaurantRequest());

        return modelAndView;
    }

    @GetMapping("/{restaurantId}/reservations/new")
    public ModelAndView createRestaurantReservation(@PathVariable Long restaurantId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reservation/reservation-create");
        CreateReservationRequest createReservationRequest = new CreateReservationRequest();
        createReservationRequest.setRestaurantId(restaurantId);
        modelAndView.addObject("createReservationRequest", createReservationRequest);

        return modelAndView;
    }

    @GetMapping("/{restaurantId}/reservations")
    private ModelAndView getReservations(@PathVariable Long restaurantId) {
        List<Reservation> reservationsByRestaurant = reservationService.getReservationsByRestaurantId(restaurantId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reservations", reservationsByRestaurant);
        modelAndView.setViewName("restaurant/restaurant-reservations");
        return modelAndView;
    }

    @GetMapping("/{restaurantId}/orders")
    public ModelAndView getOrders(@PathVariable Long restaurantId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/restaurant-orders");
        List<OrderResponse> orders = orderService.getOrdersByRestaurantId(restaurantId);
        modelAndView.addObject("orders", orders);

        return modelAndView;
    }
}