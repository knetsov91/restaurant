package restaurant.com.restaurant.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handle(Exception e, HttpServletRequest request) {
        log.error(e.toString());

        String url = request.getRequestURL().toString();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error-page");
        modelAndView.addObject("url", url);

        return modelAndView;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleForbidden(AccessDeniedException e) {
        log.error(e.getMessage());
        log.error(e.getClass().getName());
        return "redirect:/home";
    }
}
