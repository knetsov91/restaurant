package restaurant.com.restaurant.order.client.dto;

import lombok.Data;
import restaurant.com.restaurant.order.OrderStatus;

@Data
public class ChangeOrderStatusRequest {

    private OrderStatus orderStatus;
}
