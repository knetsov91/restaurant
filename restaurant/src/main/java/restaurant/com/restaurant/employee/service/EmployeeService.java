package restaurant.com.restaurant.employee.service;

import org.springframework.stereotype.Service;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.employee.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}