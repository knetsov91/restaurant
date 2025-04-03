package restaurant.com.restaurant.menu.service;

import org.springframework.stereotype.Service;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.repository.MenuRepository;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.menuitem.service.MenuItemService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;import restaurant.com.restaurant.web.dto.CreateMenuRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantService restaurantService;
    private final MenuItemService menuItemService;

    public MenuService(MenuRepository menuRepository, RestaurantService restaurantService, MenuItemService menuItemService) {
        this.menuRepository = menuRepository;
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
    }

    public void createMenu(CreateMenuRequest createMenuRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(createMenuRequest.getRestaurantId());

        Menu menu = new Menu();
        menu.setRestaurant(restaurant);
        menu.setTitle(createMenuRequest.getTitle());
        menu.setCreatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

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

    public void addMenuItem(UUID menuItemId, Long menuId) {
        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);

        Menu menu = getMenuById(menuId);
        menu.getMenuItems().add(menuItem);

        menuRepository.save(menu);
    }
}