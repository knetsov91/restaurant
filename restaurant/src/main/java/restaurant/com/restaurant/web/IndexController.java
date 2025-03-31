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

    @GetMapping("/panel")
    public String resolve(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
        UserRole userRole = authenticatedUser.getUserRole();

        String view = renderView(userRole);
        return view;
    }

    private static String renderView(UserRole role) {
        switch (role) {
            case ADMIN:
                return "admin-panel";
            case OWNER:
                return "owner-panel";
            case EMPLOYEE:
                return "redirect:/employees/panel";
            default:
                return "redirect:/home";
        }
    }
}
