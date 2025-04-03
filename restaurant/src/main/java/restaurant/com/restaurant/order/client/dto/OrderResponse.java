package restaurant.com.restaurant.order.client.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class OrderResponse {

    private Long orderId;

    private LocalDateTime orderDate;

    private LocalDateTime finishDate;

    private String orderStatus;

    private UUID waiterId;

    private Long restaurantId;

    private UUID clientId;

    private List<OrderInfoResponse> orderInfoResponses;
}