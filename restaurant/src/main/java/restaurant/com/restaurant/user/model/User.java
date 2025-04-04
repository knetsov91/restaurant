package restaurant.com.restaurant.user.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="`user`")
public class  User {

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

    private boolean passwordChanged;

    private LocalDateTime passwordChangedAt;

    private boolean isActive;

    @Column
    private LocalDateTime createdOn;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
