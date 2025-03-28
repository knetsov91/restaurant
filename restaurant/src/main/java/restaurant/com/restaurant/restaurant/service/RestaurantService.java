package restaurant.com.restaurant.restaurant.service;

import org.springframework.stereotype.Service;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.repository.RestaurantRepository;
import restaurant.com.restaurant.web.dto.CreateRestaurantRequest;
import java.time.LocalDate;
import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void createRestaurant(CreateRestaurantRequest createRestaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setCreatedAt(LocalDate.now());
        restaurant.setName(createRestaurantRequest.getName());
        restaurant.setAddress(createRestaurantRequest.getAddress());
        restaurant.setCapacity(createRestaurantRequest.getCapacity());
        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository
                .findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant with id " + restaurantId + " not found"));
    }
}
