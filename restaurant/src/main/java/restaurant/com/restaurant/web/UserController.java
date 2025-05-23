package restaurant.com.restaurant.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.model.UserRole;
import restaurant.com.restaurant.user.service.UserService;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView getUsers() {
        List<User> allUsers = userService.getAllUsers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/users");
        modelAndView.addObject("users", allUsers);

        return modelAndView;
    }

    @PutMapping("/{email}/role")
    public ModelAndView updateUserRole(@PathVariable String email, @RequestParam UserRole role) {
        userService.changerRole(email,role);
        return new ModelAndView("redirect:/users");

    }
}
