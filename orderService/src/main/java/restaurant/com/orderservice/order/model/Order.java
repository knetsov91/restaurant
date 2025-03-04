package restaurant.com.orderservice.order.model;

import jakarta.persistence.*;
import lombok.Data;
import restaurant.com.restaurant.order.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private LocalDateTime finisedAt;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    LocalDateTime createdAt;


}
