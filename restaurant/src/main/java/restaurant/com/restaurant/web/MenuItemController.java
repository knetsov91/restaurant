package restaurant.com.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.menuitem.service.MenuItemService;
import restaurant.com.restaurant.web.dto.MenuItemsRequest;
import java.util.List;

@Controller
@RequestMapping("/menu-items")
public class MenuItemController {

    private MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public ModelAndView getItems() {
        List<MenuItem> items = menuItemService.getAllMenuItems();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-items");
        modelAndView.addObject("items", items);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createItem() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-items-create");
        modelAndView.addObject("items", List.of());
        modelAndView.addObject("menuItemsRequest", MenuItemsRequest.builder().build());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView postItems(MenuItemsRequest menuItemsRequest, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
                    return new ModelAndView("menu-items-create");
        }

        menuItemService.createMenuItem(menuItemsRequest);
        return new ModelAndView("redirect:/menu/items");
    }
}