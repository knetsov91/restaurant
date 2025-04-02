package restaurant.com.restaurant.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateReservationRequest {

    @NotNull
    @Positive(message = "Reservation must be for at least 1 customer")
    private int customersNumber;

    private Long restaurantId;

    @NotNull(message = "Please select reservation date")
    private LocalDateTime reservationDate;

    @NotEmpty(message = "Please enter phone number")
    @Size(min=10, max = 10, message = "Number should be 10 digits")
    private String phoneNumber;
}