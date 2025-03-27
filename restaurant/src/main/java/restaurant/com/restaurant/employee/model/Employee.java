package restaurant.com.restaurant.employee.model;

import jakarta.persistence.*;
import lombok.Data;
import restaurant.com.restaurant.employeeInfo.model.EmployeeInfo;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import java.util.UUID;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToOne
    @JoinColumn(nullable = false, name = "employeeInfoId")
    private EmployeeInfo employeeInfo;

    @ManyToOne
    private Restaurant restaurant;
}