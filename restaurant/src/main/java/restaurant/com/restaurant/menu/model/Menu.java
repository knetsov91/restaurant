package restaurant.com.restaurant.menu.model;

import jakarta.persistence.*;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "menu")
    private Set<MenuItem> menuItems;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;
}
