package restaurant.com.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.order.client.dto.OrderResponse;
import restaurant.com.restaurant.order.service.OrderService;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView getOrders() {
        List<OrderResponse> orders = orderService.getOrders();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order/orders");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
}