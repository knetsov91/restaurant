package restaurant.com.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.web.dto.MenuItemsRequest;
import restaurant.com.restaurant.web.dto.RegisterRequest;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuItemController {


    @GetMapping("/items")
    public ModelAndView getItems() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-items");
        modelAndView.addObject("items", List.of());
        return modelAndView;

    }

    @GetMapping("/items/create")
    public ModelAndView createItem() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-items-create");
        modelAndView.addObject("items", List.of());
        modelAndView.addObject("menuItemsRequest", MenuItemsRequest.builder().build());
        return modelAndView;

    }

}
