package restaurant.com.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.employee.model.EmployeeType;
import restaurant.com.restaurant.employee.repository.EmployeeRepository;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.repository.RestaurantRepository;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.model.UserRole;
import restaurant.com.restaurant.user.repository.UserRepository;
import restaurant.com.restaurant.user.service.UserService;
import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;
import restaurant.com.restaurant.web.dto.CreateRestaurantRequest;
import restaurant.com.restaurant.web.dto.CreateUserRequest;
import restaurant.com.restaurant.web.mapper.DtoMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CreateEmployeeITest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createEmployee() {

        CreateRestaurantRequest createRestaurantRequest = new CreateRestaurantRequest();
        createRestaurantRequest.setName("Restaurant Name");
        createRestaurantRequest.setAddress("Restaurant Address");
        createRestaurantRequest.setCapacity(22);
        restaurantService.createRestaurant(createRestaurantRequest);
        Restaurant restaurant = restaurantService.getRestaurantById(1L);

        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setFirstName("Restaurant First Name");
        createEmployeeRequest.setLastName("Restaurant Last Name");
        createEmployeeRequest.setEmail("restaurant.com@gmail.com");
        createEmployeeRequest.setPassword("restaurant.com");
        createEmployeeRequest.setAge(22);
        createEmployeeRequest.setEmployeeType(EmployeeType.WAITER);
        createEmployeeRequest.setSalary(BigDecimal.valueOf(1222.3));

        CreateUserRequest createUserRequest = DtoMapper.mapCreateEmployeeRequestToCreateUserRequest(createEmployeeRequest);
        createUserRequest.setRole(UserRole.EMPLOYEE);
        User user = userService.createUser(createUserRequest);

        Employee employee = DtoMapper.mapCreateEmployeeRequestToEmployee(createEmployeeRequest);
        employee.setEmployeeType(createEmployeeRequest.getEmployeeType());
        employee.setUser(user);
        employee.setRestaurant(restaurant);
        employee.setHireDate(LocalDateTime.now());

        employeeRepository.save(employee);

        assertEquals(1, restaurantRepository.count());
        assertEquals(1, userRepository.count());
        assertEquals(1, employeeRepository.findAll().size());
    }
}
