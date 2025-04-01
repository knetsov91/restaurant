package restaurant.com.restaurant.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.employee.service.EmployeeService;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.service.MenuService;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.menuitem.service.MenuItemService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateMenuRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/menus")
public class MenuController {

    private final MenuItemService menuItemService;
    private MenuService menuService;
    private RestaurantService restaurantService;
    private EmployeeService employeeService;

    public MenuController(MenuService menuService, RestaurantService restaurantService, MenuItemService menuItemService, EmployeeService employeeService) {
        this.menuService = menuService;
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
        this.employeeService = employeeService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public ModelAndView getAllMenus(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
        List<Menu> allMenus = menuService.getAllMenus();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/menus");
        modelAndView.addObject("menus", allMenus);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreateMenu(@RequestParam(required = false) Long restaurantId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/menu-create");

        CreateMenuRequest attributeValue = new CreateMenuRequest();

        if (restaurantId != null) {
            attributeValue.setRestaurantId(restaurantId);
            modelAndView.addObject("createMenuRequest", attributeValue);
            return modelAndView;
        }
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        modelAndView.addObject("createMenuRequest", attributeValue);
        modelAndView.addObject("restaurants", restaurants);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView createMenu(CreateMenuRequest createMenuRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Restaurant> restaurants = restaurantService.getRestaurants();
            ModelAndView modelAndView = new ModelAndView("menu/menu-create");
            modelAndView.addObject("restaurants", restaurants);

            return modelAndView;
        }
        menuService.createMenu(createMenuRequest);
        return new ModelAndView("redirect:/menus");
    }

    @GetMapping("/{menuId}/menu-items/add")
    public ModelAndView getMenuItemToMenu(@PathVariable Long menuId) {
        List<MenuItem> allMenuItems = menuItemService.getAllMenuItems();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/menu-add-item");
        modelAndView.addObject("allMenuItems", allMenuItems);

        return modelAndView;
    }
    @PostMapping("/{menuId}/menu-items/{menuItemId}")
    public ModelAndView addMenuItemToMenu(@PathVariable Long menuId, @PathVariable UUID menuItemId) {
        menuService.addMenuItem(menuItemId, menuId);
        return new ModelAndView("redirect:/menus/" + menuId);
    }

    @GetMapping("/{menuId}")
    public ModelAndView getMenu(@PathVariable(name="menuId") Long menuId) {
        Menu menu = menuService.getMenuById(menuId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/menu");
        modelAndView.addObject("menu", menu);

        return modelAndView;
    }
}