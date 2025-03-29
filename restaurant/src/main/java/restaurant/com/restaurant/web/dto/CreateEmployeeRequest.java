package restaurant.com.restaurant.web.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import restaurant.com.restaurant.employee.model.EmployeeType;
import java.math.BigDecimal;

@Data
public class CreateEmployeeRequest {
    @Email
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    @Size(min = 2)
    private String firstName;

    @Size(min = 2)
    @NotBlank
    private String lastName;

    @Positive
    private int age;

    @Positive
    @NotNull
    private BigDecimal salary;

    @NotNull
    private EmployeeType employeeType;

    private Long restaurantId;
}