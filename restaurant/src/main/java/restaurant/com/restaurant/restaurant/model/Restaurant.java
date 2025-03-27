package restaurant.com.restaurant.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import restaurant.com.restaurant.kitchen.model.Kitchen;
import java.time.LocalDate;

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
}
