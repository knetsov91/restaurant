package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import restaurant.com.restaurant.TestBuilder;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.employee.service.EmployeeService;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.service.MenuService;
import restaurant.com.restaurant.menuitem.service.MenuItemService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.user.model.UserRole;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MenuController.class)
class MenuControllerApiTest {

    @MockitoBean
    private  MenuItemService menuItemService;

    @MockitoBean
    private MenuService menuService;

    @MockitoBean
    private RestaurantService restaurantService;

    @MockitoBean
    private EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAuthenticatedRequestToMenusEndpoint_shouldRenderMenusView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        authenticatedUser.setUserRole(UserRole.ADMIN);

        Restaurant restaurant = TestBuilder.createRestaurant();

        Menu menu = new Menu();
        menu.setRestaurant(restaurant);

        when(menuService.getAllMenus())
                .thenReturn(List.of(menu));

        MockHttpServletRequestBuilder req = get("/menus")
                .with(user(authenticatedUser));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("menu/menus"))
                .andExpect(model().attributeExists("menus"));
    }

    @Test
    void getAuthenticatedRequestToMenuCreateEndpointWithoutQueryParameter_shouldRenderMenuCreateView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();
        MockHttpServletRequestBuilder req = get("/menus/create")
                .with(user(authenticatedUser));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("menu/menu-create"));
    }
}