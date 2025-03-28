package restaurant.com.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public ModelAndView getEmployees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employees");


        return modelAndView;
    }
}