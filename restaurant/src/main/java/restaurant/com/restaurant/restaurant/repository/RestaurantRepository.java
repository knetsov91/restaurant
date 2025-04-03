package restaurant.com.restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.com.restaurant.restaurant.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
