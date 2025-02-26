package restaurant.com.restaurant.order.model;

import jakarta.persistence.*;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.waiter.model.Waiter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tableName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private LocalDateTime finisedAt;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    LocalDateTime createdAt;

    @ManyToOne
    private Waiter waiter;

    @OneToMany(mappedBy = "order")
    private List<MenuItem> menuItems;
}
