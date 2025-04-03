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
}