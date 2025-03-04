package restaurant.com.restaurant.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Set;
import java.util.UUID;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

    private final Set<String> ALLOWED_URLS = Set.of("/", "/login", "/register");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getServletPath();
        if (ALLOWED_URLS.contains(url)) {
            return true;
        }

        HttpSession session = request.getSession();
        UUID userId = (UUID) session.getAttribute("userId");

        if ( userId != null ) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
}
