package restaurant.com.restaurant.menu.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurant.com.restaurant.TestBuilder;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.repository.MenuRepository;
import restaurant.com.restaurant.menuitem.service.MenuItemService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateMenuRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuServiceUTest {

    @Mock
    private MenuRepository menuRepository;

    @Mock
    private RestaurantService restaurantService;

    @Mock
    private MenuItemService menuItemService;

    @InjectMocks
    private MenuService menuService;

    @Test
    public void givenValidData_whenCreateMenu_thenCreateMenu() {

        CreateMenuRequest createMenuRequest = new CreateMenuRequest();
        createMenuRequest.setRestaurantId(1L);
        createMenuRequest.setTitle("Test");

        Restaurant restaurant = TestBuilder.createRestaurant();
        when(restaurantService.getRestaurantById(1L)).thenReturn(restaurant);

        Menu menu = new Menu();
        menu.setRestaurant(restaurant);
        menu.setTitle("Test");
        menu.setCreatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        menuService.createMenu(createMenuRequest);

        verify(menuRepository, times(1)).save(menu);
    }
}