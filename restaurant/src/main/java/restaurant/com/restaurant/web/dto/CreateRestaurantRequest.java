package restaurant.com.restaurant.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateRestaurantRequest {

    @Size(min = 2, max = 50)
    @NotBlank
    private String name;

    @Positive
    private int capacity;

    @Size(min = 2, max = 50)
    @NotBlank
    private String address;
}
