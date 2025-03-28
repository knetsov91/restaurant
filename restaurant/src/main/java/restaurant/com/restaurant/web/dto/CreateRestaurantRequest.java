package restaurant.com.restaurant.web.dto;

import lombok.Data;

@Data
public class CreateRestaurantRequest {

    private String name;

    private int capacity;

    private String address;
}
