package restaurant.com.restaurant.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Set;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

    private final Set<String> ALLOWED_URLS = Set.of("/", "/login", "/register");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getServletPath();
        if (ALLOWED_URLS.contains(url)) {
            return true;
        }

        return false;
    }
}
