package restaurant.com.restaurant.web.dto;

import lombok.Data;

@Data
public class CreateMenuRequest {

    private String title;
    private Long restaurantId;
}
