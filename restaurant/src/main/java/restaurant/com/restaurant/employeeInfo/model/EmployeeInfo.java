package restaurant.com.restaurant.employeeInfo.model;

import jakarta.persistence.*;
import restaurant.com.restaurant.user.model.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private LocalDateTime hireDate;

    @Column(nullable = false)
    private BigDecimal salary;

    @Column(nullable = false)
    private boolean active;

    private LocalDateTime releaseDate;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}