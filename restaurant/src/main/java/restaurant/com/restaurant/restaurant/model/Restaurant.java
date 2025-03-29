package restaurant.com.restaurant.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import restaurant.com.restaurant.employee.model.Employee;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.reservation.model.Reservation;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "restaurant")
    @ToString.Exclude
    private List<Menu> menus;

    @OneToMany(mappedBy = "restaurant")
    private List<Employee> employees;

    @OneToMany(mappedBy = "restaurant")
    private List<Reservation> reservation;
}
