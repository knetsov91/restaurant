package restaurant.com.restaurant.web.dto;

import lombok.Data;
import restaurant.com.restaurant.reservation.model.ReservationStatus;

@Data
public class ChangeReservationStatusRequest {

    private ReservationStatus reservationStatus;
}
