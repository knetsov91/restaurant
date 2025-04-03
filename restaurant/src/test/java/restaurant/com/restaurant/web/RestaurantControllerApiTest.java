package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import restaurant.com.restaurant.TestBuilder;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.employee.service.EmployeeService;
import restaurant.com.restaurant.menu.service.MenuService;
import restaurant.com.restaurant.order.service.OrderService;
import restaurant.com.restaurant.reservation.service.ReservationService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerApiTest {

    @MockitoBean
    private RestaurantService restaurantService;

    @MockitoBean
    private EmployeeService employeeService;

    @MockitoBean
    private MenuService menuService;

    @MockitoBean
    private ReservationService reservationService;

    @MockitoBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAuthenticatedRequestToRestaurantsIndexEndpoint_renderRestaurantsView() throws Exception {

        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();


        MockHttpServletRequestBuilder request = get("/restaurants")
                .with(user(authenticatedUser));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(view().name("restaurant/restaurants"));

    }

    @Test
    void getAuthenticatedRequestToRestaurantMenusEndpoint_shouldRenderMenusView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        Restaurant restaurant = TestBuilder.createRestaurant();

        MockHttpServletRequestBuilder request = get("/restaurants/1/menus").with(user(authenticatedUser));
        when(restaurantService.getRestaurantById(1L)).thenReturn(restaurant);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(view().name("restaurant/restaurant-menus"));
    }

    @Test
    void getAuthenticatedRequestToRestaurantEmployeesEndpoint_shouldRenderRestaurantEmployeesView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        Restaurant restaurant = TestBuilder.createRestaurant();

        MockHttpServletRequestBuilder request = get("/restaurants/1/employees")
                .with(user(authenticatedUser));

        when(restaurantService.getRestaurantById(1L)).thenReturn(restaurant);
        when(restaurantService.getRestaurantEmployees(restaurant.getId())).thenReturn(new ArrayList<Employee>());
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(view().name("restaurant/restaurant-employees"))
                .andExpect(model().attributeExists("employees"))
                .andExpect(model().attributeExists("restaurantName"));
    }
}