package restaurant.com.restaurant.reservation.service;

import org.springframework.stereotype.Service;
import restaurant.com.restaurant.reservation.model.Reservation;
import restaurant.com.restaurant.reservation.model.ReservationStatus;
import restaurant.com.restaurant.reservation.repository.ReservationRepository;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateReservationRequest;
import java.util.List;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private RestaurantService restaurantService;

    public ReservationService(ReservationRepository reservationRepository, RestaurantService restaurantService) {
        this.reservationRepository = reservationRepository;
        this.restaurantService = restaurantService;
    }

    public void createReservation(CreateReservationRequest createReservationRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(createReservationRequest.getRestaurantId());

        Reservation reservation = new Reservation();
        reservation.setReservationStatus(ReservationStatus.PENDING);
        reservation.setReservationDate(createReservationRequest.getReservationDate());
        reservation.setCustomersNumber(createReservationRequest.getCustomersNumber());
        reservation.setPhoneNumber(createReservationRequest.getPhoneNumber());
        reservation.setRestaurant(restaurant);

        reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByRestaurantId(Long restaurantId) {
        return reservationRepository
                .findByRestaurantId(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurnat with id " + restaurantId + " not found"));
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}