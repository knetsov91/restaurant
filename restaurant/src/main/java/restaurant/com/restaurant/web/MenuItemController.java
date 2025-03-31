package restaurant.com.restaurant.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.menuitem.service.MenuItemService;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.restaurant.service.RestaurantService;
import restaurant.com.restaurant.web.dto.CreateMenuItemRequest;
import java.util.List;

@Controller
@RequestMapping("/menu-items")
public class MenuItemController {

    private MenuItemService menuItemService;
    private RestaurantService restaurantService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService, RestaurantService restaurantService, RestaurantService restaurantService1) {
        this.menuItemService = menuItemService;
        this.restaurantService = restaurantService1;
    }

    @GetMapping
    public ModelAndView getItems() {
        List<MenuItem> items = menuItemService.getAllMenuItems();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-item/menu-items");
        modelAndView.addObject("items", items);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createItem() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-item/menu-item-create");
        modelAndView.addObject("items", List.of());
        modelAndView.addObject("restaurants", restaurants);
        modelAndView.addObject("createMenuItemRequest", CreateMenuItemRequest.builder().build());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView postItems(@Valid CreateMenuItemRequest createMenuItemRequest, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            return new ModelAndView("menu-item/menu-item-create");
        }

        menuItemService.createMenuItem(createMenuItemRequest);
        return new ModelAndView("redirect:/menu-items");
    }
}