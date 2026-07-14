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
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void givenExistingEmployeeId_whenGetEmployeeById_thenReturnEmployee() {
        Employee expectedEmployee = new Employee();
        expectedEmployee.setId(UUID.randomUUID());

        when(employeeRepository.findById(expectedEmployee.getId())).thenReturn(Optional.of(expectedEmployee));
        Employee actualEmployee = employeeService.getEmployeeById(expectedEmployee.getId());

        assertEquals(expectedEmployee.getId(), actualEmployee.getId());
        verify(employeeRepository, times(1)).findById(expectedEmployee.getId());
    }

    @Test
    void givenNonExistingEmployeeId_whenGetEmployeeById_thenThrowException() {
        UUID employeeId = UUID.randomUUID();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> employeeService.getEmployeeById(employeeId));

        assertEquals("Employee with id " + employeeId + " not found", runtimeException.getMessage());
    }

    @Test
    void whenGetAllEmployees_thenReturnEmployees() {
        UUID id = UUID.randomUUID();
        Employee employee1 = new Employee();
        employee1.setId(id);
        List<Employee> expectedEmployees = List.of(employee1);

        when(employeeRepository.findAll()).thenReturn(expectedEmployees);

        List<Employee> allEmployees = employeeService.getAllEmployees();

        assertEquals(1, allEmployees.size());
        assertEquals(employee1.getId(), allEmployees.get(0).getId());
    }

    @Test
    void givenExistingRestaurantId_whenGetRestaurantById_thenReturnListOfRestaurantEmployees() {
        Employee employee1 = new Employee();
        employee1.setId(UUID.randomUUID());

        List<Employee> expectedEmployees = List.of(employee1);

        when(employeeRepository.findByRestaurantId(any())).thenReturn(Optional.of(expectedEmployees));

        List<Employee> actualEmployees = employeeService.getAllEmployeesByRestaurantId(1L);

        assertEquals(1, actualEmployees.size());
        assertEquals(employee1.getId(), actualEmployees.get(0).getId());
    }

    @Test
    void givenNonExistingRestaurantId_whenGetRestaurantById_thenThrowException() {
        Long id = 1L;
        when(employeeRepository.findByRestaurantId(id)).thenReturn(Optional.empty());

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> employeeService.getAllEmployeesByRestaurantId(1L));
        assertEquals("Restaurant with id " + id + " not found", runtimeException.getMessage());
    }

    @Test
    void givenExistingEmail_whenGetEmployeeByUserEmail_thenEmployeeReturned() {
        User user = new User();
        user.setEmail("email@email.com");
        Employee expectedEmployee = new Employee();
        expectedEmployee.setUser(user);

        when(userService.findUserByEmail(user.getEmail())).thenReturn(user);
        when(employeeRepository.findByUser(user)).thenReturn(Optional.of(expectedEmployee));

        Employee actualEmployee = employeeService.getEmployeeByUserEmail(user.getEmail());

        assertEquals(expectedEmployee.getUser().getEmail(), actualEmployee.getUser().getEmail());
    }

    @Test
    void givenNonExistingEmail_whenGetEmployeeByUserEmail_thenThrowException() {
        String email = "email@email.com";

        when(userService.findUserByEmail(any())).thenReturn(null);
        when(employeeRepository.findByUser(any())).thenReturn(Optional.empty());

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> employeeService.getEmployeeByUserEmail(email));
        assertEquals("Employee with email " + email + " not found", runtimeException.getMessage());

    }
}