package restaurant.com.restaurant.client.model;

import jakarta.persistence.*;
import restaurant.com.restaurant.reservation.model.Reservation;
import restaurant.com.restaurant.user.model.User;
import java.util.List;
import java.util.UUID;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
}