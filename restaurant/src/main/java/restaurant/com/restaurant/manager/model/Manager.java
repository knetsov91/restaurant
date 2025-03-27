package restaurant.com.restaurant.manager.model;

import jakarta.persistence.*;
import restaurant.com.restaurant.employeeInfo.model.EmployeeInfo;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import java.util.UUID;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(nullable = false, name = "employeeInfoId")
    private EmployeeInfo employeeInfo;

    @ManyToOne
    private Restaurant restaurant;
}