package restaurant.com.restaurant.menuitem.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

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
    private String imagePath;

}
