package restaurant.com.restaurant.reservation.model;

import jakarta.persistence.*;
import restaurant.com.restaurant.client.model.Client;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false)
    private ReservationStatus reservationStatus;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToOne
    private Client client;
}
