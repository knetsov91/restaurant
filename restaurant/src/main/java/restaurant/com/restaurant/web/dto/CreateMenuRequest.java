package restaurant.com.restaurant.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateMenuRequest {

    @NotEmpty(message = "Enter menu name")
    private String title;

    @NotNull
    private Long restaurantId;
}
