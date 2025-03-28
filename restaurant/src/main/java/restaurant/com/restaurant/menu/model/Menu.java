package restaurant.com.restaurant.menu.model;

import jakarta.persistence.*;
import lombok.Data;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String title;

    private String imagePath;

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    private Set<MenuItem> menuItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;
}
