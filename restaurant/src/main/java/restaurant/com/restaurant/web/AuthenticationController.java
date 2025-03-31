package restaurant.com.restaurant.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.user.service.UserService;
import restaurant.com.restaurant.web.dto.LoginRequest;
import restaurant.com.restaurant.web.dto.RegisterRequest;

@Controller
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("registerRequest", RegisterRequest.builder().build());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerPost(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        userService.register(registerRequest);

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginRequest", new LoginRequest());

        return modelAndView;
    }

//    @PostMapping("/login")
//    public ModelAndView loginPost(LoginRequest loginRequest, BindingResult bindingResult, HttpSession session) {
//
//        if (bindingResult.hasErrors()) {
//            return new ModelAndView("login");
//        }
//
//        User login = userService.login(loginRequest);
//        session.setAttribute("userId", login.getId());
//
//        return new ModelAndView("redirect:/dashboard");
//    }
}
