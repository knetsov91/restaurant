package restaurant.com.restaurant.menuitem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.com.restaurant.order.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MenuItemType menuItem;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private BigDecimal discount;

    @Column
    private String description;

    @Column
    private String imagePath;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    private Order order;

}
