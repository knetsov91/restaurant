package restaurant.com.orderservice.web.mapper;

import restaurant.com.orderservice.order.model.Order;
import restaurant.com.orderservice.web.dto.OrderResponse;

public class DtoMapper {

    public static OrderResponse mapOrderToOrderResponse(Order order) {
        return OrderResponse
                .builder()
                .price(order.getPrice())
                .orderStatus(order.getOrderStatus())
                .createdAt(order.getCreatedAt())
                .finisedAt(order.getFinisedAt())
                .build();
    }
}
