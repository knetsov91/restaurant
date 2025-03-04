package restaurant.com.orderservice.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.com.orderservice.order.service.OrderService;
import restaurant.com.orderservice.web.dto.OrderResponse;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders() {
        List<OrderResponse> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }


}
