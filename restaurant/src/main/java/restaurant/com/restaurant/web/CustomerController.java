package restaurant.com.restaurant.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import restaurant.com.restaurant.config.AuthenticatedUser;

@Controller
public class CustomerController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {

        return "home";
    }

}
