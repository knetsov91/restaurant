package restaurant.com.restaurant.user.model;

import jakarta.persistence.*;
import restaurant.com.restaurant.order.model.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private UserRole role;


}
