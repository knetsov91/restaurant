package restaurant.com.restaurant.menu.service;

import org.springframework.stereotype.Service;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.repository.MenuRepository;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantService restaurantService;

    public MenuService(MenuRepository menuRepository, RestaurantService restaurantService) {
        this.menuRepository = menuRepository;
        this.restaurantService = restaurantService;
    }

    public void createMenu(Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);

        Menu menu = new Menu();
        menu.setRestaurant(restaurant);
        menu.setCreatedAt(LocalDateTime.now());

        menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public List<Menu> getMenusByRestaurantId(Long RestaurantId) {
        Optional<List<Menu>> menu =  menuRepository.findByRestaurantId(RestaurantId);

        return menu.orElseThrow(() -> new RuntimeException("Restaurant with id " + RestaurantId + " not found"));
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu with id " + id + " not found"));
    }
}