package restaurant.com.restaurant.reservation.model;

import jakarta.persistence.*;
import lombok.Data;
import restaurant.com.restaurant.customer.model.Customer;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int customersNumber;

    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToOne
    private Customer customer;

    @ManyToOne(optional = false)
    private Restaurant restaurant;
}
