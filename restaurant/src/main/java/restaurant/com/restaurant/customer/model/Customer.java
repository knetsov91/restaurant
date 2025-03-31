package restaurant.com.restaurant.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import restaurant.com.restaurant.reservation.model.Reservation;
import restaurant.com.restaurant.user.model.User;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String phoneNumber;

    @OneToOne(optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
}