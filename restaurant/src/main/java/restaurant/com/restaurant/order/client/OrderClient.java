package restaurant.com.restaurant.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import restaurant.com.restaurant.order.client.dto.OrderResponse;
import java.util.List;

@FeignClient(name = "order-svc", url = "${order-svc.base-url}")
public interface OrderClient {

    @GetMapping
    ResponseEntity<List<OrderResponse>> getOrders();

    @GetMapping("/restaurants/{restaurantId}")
    ResponseEntity<List<OrderResponse>> getOrdersByRestaurantId(@PathVariable Long restaurantId);
}