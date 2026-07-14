package restaurant.com.restaurant.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restaurant.com.restaurant.scheduler.OrderScheduler;

//@Component
public class AppRunner implements CommandLineRunner {


    private OrderScheduler  orderScheduler;

    public AppRunner(OrderScheduler orderScheduler) {
        this.orderScheduler = orderScheduler;
    }

    @Override
    public void run(String... args) throws Exception {
        orderScheduler.scheduled();
    }
}
