package restaurant.com.restaurant.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.com.restaurant.user.model.UserRole;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private UserRole role;
}
