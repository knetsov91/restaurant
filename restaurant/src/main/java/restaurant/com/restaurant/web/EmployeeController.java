package restaurant.com.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public ModelAndView getEmployees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employees");


        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createEmployee() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee-create");
        modelAndView.addObject("createEmployeeRequest", new CreateEmployeeRequest());
        return modelAndView;
    }

}
