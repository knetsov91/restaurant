package restaurant.com.restaurant.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.user.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByUser(User user);
    Optional<List<Employee>> findByRestaurantId(Long restaurantId);
}