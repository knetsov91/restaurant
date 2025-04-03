package restaurant.com.restaurant.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableMethodSecurity
@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(matchers ->
                    matchers.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .requestMatchers(HttpMethod.POST, "/reservations").permitAll()
                    .requestMatchers("/", "/register", "/login",
                            "/restaurants/*/menus",
                            "/menus/*",
                            "/restaurants/*/reservations/new"
                    ).permitAll()
                    .anyRequest().authenticated()
                ).formLogin(form ->
                        form.loginPage("/login")
                                .usernameParameter("email")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/panel", true)
                                .failureUrl("/login?error")
                                .permitAll()
                ).logout(logout ->
                        logout.invalidateHttpSession(true)
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                                .logoutSuccessUrl("/"))
                .build();
    }
}
