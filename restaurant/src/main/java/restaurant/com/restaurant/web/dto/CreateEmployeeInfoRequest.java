package restaurant.com.restaurant.web.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateEmployeeInfoRequest {
    private int age;

    private BigDecimal salary;
}