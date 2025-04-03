package restaurant.com.restaurant.menu.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurant.com.restaurant.TestBuilder;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.repository.MenuRepository;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.menuitem.service.MenuItemService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateMenuRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void whenGetAllMenus_happyPath() {
        when(menuRepository.findAll()).thenReturn(List.of(new Menu()));

        List<Menu> allMenus = menuService.getAllMenus();

        verify(menuRepository, times(1)).findAll();
        assertEquals(1, allMenus.size());
    }

    @Test
    public void whenAddMenuItem_happyPath() {
        UUID id = UUID.randomUUID();

        MenuItem  menuItem = new MenuItem();
        menuItem.setId(id);

        Menu menu = new Menu();
        menu.setId(1L);
        menu.getMenuItems().add(menuItem);

        when(menuItemService.getMenuItemById(id)).thenReturn(menuItem);
        when(menuRepository.findById(1L)).thenReturn(Optional.of(menu));
        menuService.addMenuItem(id, 1L);
        verify(menuRepository, times(1)).save(menu);
    }
}