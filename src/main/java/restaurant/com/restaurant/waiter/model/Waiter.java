package restaurant.com.restaurant.waiter.model;


import jakarta.persistence.*;
import org.springframework.core.Ordered;
import restaurant.com.restaurant.order.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Waiter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private LocalDateTime hireDate;

    @Column(nullable = false)
    private BigDecimal salary;

    @OneToMany(mappedBy = "waiter", fetch = FetchType.EAGER)
    private List<Order> orders;

}
