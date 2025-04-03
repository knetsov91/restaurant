package restaurant.com.restaurant.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import restaurant.com.restaurant.TestBuilder;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.menuitem.service.MenuItemService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MenuItemController.class)
class MenuItemControllerApiTest {

    @MockitoBean
    private MenuItemService menuItemService;

    @MockitoBean
    private RestaurantService restaurantService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAuthenticatedRequestToMenusItemsEndpoint_shouldRenderMenusItemsView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();


        MockHttpServletRequestBuilder req = get("/menu-items")
                .with(user(authenticatedUser));
        when(menuItemService.getAllMenuItems()).thenReturn(List.of(new MenuItem()));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("menu-item/menu-items"))
                .andExpect(model().attributeExists("items"));
    }

    @Test
    void getAuthenticatedRequestToMenusItemsCreateEndpoint_shouldRenderMenusItemsCreateView() throws Exception {
        AuthenticatedUser authenticatedUser = TestBuilder.createAuthenticatedUser();


        MockHttpServletRequestBuilder req = get("/menu-items/create")
                .with(user(authenticatedUser));
        when(restaurantService.getRestaurants()).thenReturn(List.of(new Restaurant()));

        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(view().name("menu-item/menu-item-create"))
                .andExpect(model().attributeExists("items"))
                .andExpect(model().attributeExists("restaurants"))
                .andExpect(model().attributeExists("createMenuItemRequest"));

    }
}