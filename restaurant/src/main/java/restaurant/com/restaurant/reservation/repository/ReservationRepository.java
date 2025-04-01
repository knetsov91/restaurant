package restaurant.com.restaurant.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.com.restaurant.reservation.model.Reservation;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<List<Reservation>> findByRestaurantId(Long restaurantId);
}