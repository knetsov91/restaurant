package restaurant.com.restaurant.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.com.restaurant.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
