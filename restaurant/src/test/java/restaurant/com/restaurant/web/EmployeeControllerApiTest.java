package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.servlet.View;
import restaurant.com.restaurant.TestBuilder;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.employee.model.EmployeeType;
import restaurant.com.restaurant.employee.service.EmployeeService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerApiTest {

    @MockitoBean
    private EmployeeService employeeService;

    @MockitoBean
    private RestaurantService restaurantService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private View view;

    @Test
    void getAuthenticatedRequestToEmployeePanel_shouldRenderRenderEmployeePanel() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        Restaurant restaurant = TestBuilder.createRestaurant();
        MockHttpServletRequestBuilder req = get("/employees/panel")
                .with(user(authenticatedUser));
        Employee employee = new Employee();
        employee.setEmployeeType(EmployeeType.WAITER);
        employee.setId(authenticatedUser.getUserId());
        employee.setRestaurant(restaurant);

        when(employeeService.getEmployeeByUserEmail(authenticatedUser.getEmail())).thenReturn(employee);
        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("restaurantId"));
    }

    @Test
    void getAuthenticatedRequestToEmployeesEndpointWithoutRequestParameter_shouldRenderViewWithAllEmployees() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        MockHttpServletRequestBuilder req = get("/employees")
                .with(user(authenticatedUser));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("employee/employees"))
                .andExpect(model().attributeExists("employees"));
    }

    @Test
    void getAuthenticatedRequestToEmployeesEndpointWithRequestParameter_shouldRenderViewWithAllEmployees() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        MockHttpServletRequestBuilder req = get("/employees").param("restaurantId", "1")
                .with(user(authenticatedUser));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("employee/employees"))
                .andExpect(model().attributeExists("employees"));
    }

    @Test
    void getAuthenticatedRequestToEmployeeCreateEndpoint_shouldRenderViewForCreateEmployee() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        List<Restaurant> restaurants = List.of(new Restaurant());

        MockHttpServletRequestBuilder req = get("/employees/create")
                .with(user(authenticatedUser));

        when(restaurantService.getRestaurants()).thenReturn(restaurants);

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("employee/employee-create"))
                .andExpect(model().attributeExists("restaurants"));
    }

    @Test
    void getAuthenticatedRequestToShowEmployeeEndpoint_shouldRenderViewForEmployee() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        Employee employee = new Employee();
        employee.setId(authenticatedUser.getUserId());

        MockHttpServletRequestBuilder req = get("/employees/{employeeId}", employee.getId())
                .with(user(authenticatedUser));

        when(employeeService.getEmployeeById(authenticatedUser.getUserId())).thenReturn(employee);

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("employee/employee-view"))
                .andExpect(model().attributeExists("employee"));
    }
}