package restaurant.com.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.service.MenuService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateMenuRequest;
import java.util.List;

@Controller
@RequestMapping("/menus")
public class MenuController {

    private MenuService menuService;
    private RestaurantService restaurantService;

    public MenuController(MenuService menuService, RestaurantService restaurantService) {
        this.menuService = menuService;
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ModelAndView getAllMenus() {
        List<Menu> allMenus = menuService.getAllMenus();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menus");
        modelAndView.addObject("menus", allMenus);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreateMenu() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-create");
        modelAndView.addObject("createMenuRequest", new CreateMenuRequest());
        modelAndView.addObject("restaurants", restaurants);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView createMenu(CreateMenuRequest createMenuRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Restaurant> restaurants = restaurantService.getRestaurants();
            ModelAndView modelAndView = new ModelAndView("menu-create");
            modelAndView.addObject("restaurants", restaurants);

            return modelAndView;
        }
        menuService.createMenu(createMenuRequest);
        return new ModelAndView("redirect:/menu-items");
    }

    @GetMapping("/{menuId}")
    public ModelAndView getMenu(@PathVariable(name="menuId") Long menuId) {
        Menu menu = menuService.getMenuById(menuId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu");
        modelAndView.addObject("menu", menu);

        return modelAndView;
    }
}