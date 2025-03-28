package restaurant.com.restaurant.web.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateEmployeeRequest {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private int age;

    private BigDecimal salary;
}
