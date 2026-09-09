package restaurant.com.restaurant;


import restaurant.com.restaurant.config.AuthenticatedUser;
import restaurant.com.restaurant.restaurant.model.Restaurant;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.user.model.UserRole;

import java.time.LocalDate;
import java.util.UUID;

public class TestBuilder {

    public static User createUser() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setPassword("password");
        user.setRole(UserRole.EMPLOYEE);
        user.setActive(true);

        return user;
    }

    public static AuthenticatedUser createAuthenticatedUser() {
        return new AuthenticatedUser(
                "restaurant.com@gmail.com",
                "restaurant.com",
                true,
                UserRole.EMPLOYEE,
                UUID.randomUUID()
        );
    }

    public static Restaurant createRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1L);
        restaurant.setName("Restaurant");
        restaurant.setCreatedAt(LocalDate.now());
        restaurant.setCapacity(22);
        return restaurant;
    }
}
