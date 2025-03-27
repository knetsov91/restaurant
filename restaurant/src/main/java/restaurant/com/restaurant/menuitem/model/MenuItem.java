package restaurant.com.restaurant.menuitem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.com.restaurant.menu.model.Menu;


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
    private MenuItemType menuItemType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private BigDecimal discount;

    @Column(nullable = false)
    private boolean inMenu;

    @Column(nullable = false)
    private String description;

    @Column
    private String imagePath;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Menu menu;
}
