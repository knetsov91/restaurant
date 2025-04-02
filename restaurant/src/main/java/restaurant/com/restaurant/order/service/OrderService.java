package restaurant.com.restaurant.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import restaurant.com.restaurant.order.client.OrderClient;
import restaurant.com.restaurant.order.client.dto.OrderResponse;
import java.util.List;

@Service
public class OrderService {

    private OrderClient orderClient;

    @Autowired
    public OrderService(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public List<OrderResponse> getOrders() {
        ResponseEntity<List<OrderResponse>> orders = orderClient.getOrders();
        HttpStatusCode statusCode = orders.getStatusCode();

        return orders.getBody();
    }

    public List<OrderResponse> getOrdersByRestaurantId(Long restaurantId) {
        ResponseEntity<List<OrderResponse>> ordersByRestaurantId = orderClient.getOrdersByRestaurantId(restaurantId);
        HttpStatusCode statusCode = ordersByRestaurantId.getStatusCode();
        return ordersByRestaurantId.getBody();
    }
}