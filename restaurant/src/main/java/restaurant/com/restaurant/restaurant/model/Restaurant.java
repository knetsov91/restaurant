package restaurant.com.restaurant.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import restaurant.com.restaurant.kitchen.model.Kitchen;
import restaurant.com.restaurant.menu.model.Menu;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int capacity;

    private String address;

    private LocalDate createdAt;

    @OneToOne(mappedBy = "restaurant")
    private Kitchen kitchen;

    @OneToMany(mappedBy = "restaurant")
    @ToString.Exclude
    private List<Menu> menus;
}
