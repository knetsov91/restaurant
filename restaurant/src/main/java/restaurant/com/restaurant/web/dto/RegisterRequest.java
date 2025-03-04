package restaurant.com.restaurant.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @Email(message = "Enter valid email")
    @NotBlank(message = "Email must not be empty")
    private String email;

    @NotBlank(message = "Password must not be empty")
    @Size(min = 6, message = "Password should be more than 6 symbols")
    private String password;

    @NotBlank(message = "Password must not be empty")
    @Size(min = 6, message = "Password should be more than 6 symbols")
    private String passwordConfirmation;


}
