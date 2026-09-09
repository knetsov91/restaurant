package restaurant.com.restaurant.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.user.model.UserRole;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handle(@AuthenticationPrincipal AuthenticatedUser user, Exception e) {
        log.error(e.toString());
        ModelAndView modelAndView = createModelAndView("Something went wrong.", user.getUserRole());

        return modelAndView;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleForbidden(@AuthenticationPrincipal AuthenticatedUser user, AccessDeniedException e) {
        log.error(e.toString());
        ModelAndView modelAndView = createModelAndView("Resource not found.", user.getUserRole());

        return modelAndView;
    }

    private static String renderView(UserRole role) {
        if (role.equals(UserRole.CUSTOMER)) {
            return "/home";
        }
        return "/panel";
    }

    private static ModelAndView createModelAndView(String message, UserRole role) {
        String view = renderView(role);

        ModelAndView mw = new ModelAndView();
        mw.setViewName("error-page");
        mw.addObject("url", view);
        mw.addObject("message", message);

        return mw;
    }
}
