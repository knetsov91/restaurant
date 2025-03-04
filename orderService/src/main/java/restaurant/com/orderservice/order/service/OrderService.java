package restaurant.com.orderservice.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.com.orderservice.order.model.Order;
import restaurant.com.orderservice.order.repository.OrderRepository;
import restaurant.com.orderservice.web.dto.OrderResponse;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private OrderResponse map(Order order) {
        return OrderResponse
                .builder()
                .price(order.getPrice())
                .orderStatus(order.getOrderStatus())
                .createdAt(order.getCreatedAt())
                .finisedAt(order.getFinisedAt())
                .build();
    }
}
