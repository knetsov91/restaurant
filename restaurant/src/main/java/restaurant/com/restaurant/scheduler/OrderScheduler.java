package restaurant.com.restaurant.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import restaurant.com.restaurant.order.client.dto.OrderResponse;
import restaurant.com.restaurant.order.service.OrderService;
import java.util.List;

@Component
@Slf4j
public class OrderScheduler {
    private OrderService orderService;

    public OrderScheduler(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(fixedRate = 10000)
    public void scheduled() {
        List<OrderResponse> orders = orderService.getOrders();

//        log.info(orders.size());
        System.out.println("Executing scheduled");

    }
}
