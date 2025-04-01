package restaurant.com.restaurant.employee.service;

import org.springframework.stereotype.Service;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.employee.repository.EmployeeRepository;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.model.UserRole;
import restaurant.com.restaurant.user.service.UserService;
import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;
import restaurant.com.restaurant.web.dto.CreateUserRequest;
import restaurant.com.restaurant.web.mapper.DtoMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;

    public EmployeeService(EmployeeRepository employeeRepository, UserService userService, RestaurantService restaurantService) {
        this.employeeRepository = employeeRepository;
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    private List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void createEmployee(CreateEmployeeRequest createEmployeeRequest) {

        CreateUserRequest createUserRequest = DtoMapper.mapCreateEmployeeRequestToCreateUserRequest(createEmployeeRequest);
        createUserRequest.setRole(UserRole.EMPLOYEE);

        User user = userService.createUser(createUserRequest);

        Restaurant restaurant = restaurantService.getRestaurantById(createEmployeeRequest.getRestaurantId());

        Employee employee = DtoMapper.mapCreateEmployeeRequestToEmployee(createEmployeeRequest);
        employee.setHireDate(LocalDateTime.now());
        employee.setUser(user);
        employee.setRestaurant(restaurant);

        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(UUID employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with id " + employeeId + " not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getAllEmployeesByRestaurantId(Long restaurantId) {
        return employeeRepository.findByRestaurantId(restaurantId);
    }
    
    public Employee getEmployeeByUserId(String email) {
        User user = userService.findUserByEmail(email);
        return employeeRepository.findByUser(user).orElseThrow(() -> new RuntimeException("Employee with email " + email + " not found"));
    }
}