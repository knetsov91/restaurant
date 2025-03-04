package restaurant.com.orderservice.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.com.orderservice.order.model.Order;
import restaurant.com.orderservice.order.repository.OrderRepository;
import restaurant.com.orderservice.web.dto.CreateOrderRequest;
import restaurant.com.orderservice.web.dto.OrderRequest;
import restaurant.com.orderservice.web.dto.OrderResponse;
import restaurant.com.orderservice.web.mapper.DtoMapper;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(DtoMapper::mapOrderToOrderResponse)
                .toList();
    }

    public UUID createOrder(CreateOrderRequest createOrderRequest) {

        Order order = DtoMapper.mapOrderToOrderResponse(createOrderRequest);
        orderRepository.save(order);
        LOGGER.info("Order {} created: {}", order.getId(), order.getCreatedAt());
        return order.getId();
    }

}
