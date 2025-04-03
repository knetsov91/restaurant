package restaurant.com.restaurant.employee.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.employee.repository.EmployeeRepository;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.service.UserService;
import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceUTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private UserService userService;

    @Mock
    private RestaurantService restaurantService;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void createEmployee_happyPath() {
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();

        User user = new User();
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1L);
        when(userService.createUser(any())).thenReturn(any());
        when(restaurantService.getRestaurantById(restaurant.getId())).thenReturn(restaurant);
        Employee employee = new Employee();
        employee.setRestaurant(restaurant);
        employee.setUser(user);
        employeeService.createEmployee(createEmployeeRequest);

        verify(employeeRepository, times(1)).save(any());
    }
}