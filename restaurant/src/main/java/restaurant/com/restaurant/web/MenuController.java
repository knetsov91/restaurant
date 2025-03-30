package restaurant.com.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.service.MenuService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateMenuRequest;
import java.util.List;

@Controller
public class MenuController {

    private MenuService menuService;
    private RestaurantService restaurantService;

    public MenuController(MenuService menuService, RestaurantService restaurantService) {
        this.menuService = menuService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/menus")
    public ModelAndView getAllMenus() {
        List<Menu> allMenus = menuService.getAllMenus();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menus");
        modelAndView.addObject("menus", allMenus);

        return modelAndView;
    }

    @GetMapping("/restaurants/{restaurantId}/menus")
    public ModelAndView getAllRestaurantMenus(@PathVariable(name = "restaurantId") Long restaurantId) {

        List<Menu> menus = menuService.getMenusByRestaurantId(restaurantId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menus", menus);
        modelAndView.setViewName("menus");
        return modelAndView;
    }

    @GetMapping("/menus/create")
    public ModelAndView getCreateMenu() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-create");
        modelAndView.addObject("createMenuRequest", new CreateMenuRequest());
        modelAndView.addObject("restaurants", restaurants);

        return modelAndView;
    }

    @GetMapping("/menus/{menuId}")
    public ModelAndView getMenu(@PathVariable(name="menuId") Long menuId) {
        Menu menu = menuService.getMenuById(menuId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu");
        modelAndView.addObject("menu", menu);

        return modelAndView;

    }
}