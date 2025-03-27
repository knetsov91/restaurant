package restaurant.com.restaurant.kitchen.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Kitchen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<UUID> orderIds;

    @OneToOne
    @JoinColumn(nullable = false,name="restaurant_id", unique = true)
    @ToString.Exclude
    private Restaurant restaurant;
}
