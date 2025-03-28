package restaurant.com.restaurant.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.user.model.UserRole;

@Controller
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }
 
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
        UserRole userRole = authenticatedUser.getUserRole();

        if (userRole == UserRole.ADMIN) {
            return "redirect:/panel";
        }
        return "home";
    }

}
