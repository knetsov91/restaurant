package restaurant.com.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.menu.model.Menu;
import restaurant.com.restaurant.menu.service.MenuService;
import java.util.List;

@Controller
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
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
    public ModelAndView getAllRestaurantMenus(@PathVariable(name = "restaurantId") Long restaurantId, Model model) {

        List<Menu> menus = menuService.getMenusByRestaurantId(restaurantId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menus", menus);
        modelAndView.setViewName("menus");
        return modelAndView;
    }
}