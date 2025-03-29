package restaurant.com.restaurant.web.mapper;

import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;
import restaurant.com.restaurant.web.dto.CreateMenuItemRequest;
import restaurant.com.restaurant.web.dto.CreateUserRequest;
import java.time.LocalDateTime;

public class DtoMapper {

    public static CreateUserRequest mapCreateEmployeeRequestToCreateUserRequest(CreateEmployeeRequest createUserRequest) {

        return CreateUserRequest
                .builder()
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .build();
    }

    public static User mapCreateUserRequestToUser(CreateUserRequest createUserRequest) {

        return User
                .builder()
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .build();
    }

    public static MenuItem mapCreateMenuItemRequestToMenuItem(CreateMenuItemRequest menuItemsRequest) {
        return MenuItem
                .builder()
                .name(menuItemsRequest.getName())
                .menuItemType(menuItemsRequest.getMenuItemType())
                .price(menuItemsRequest.getPrice())
                .discount(menuItemsRequest.getDiscount())
                .createdAt(LocalDateTime.now())
                .description(menuItemsRequest.getDescription())
                .imagePath(menuItemsRequest.getImagePath())
                .discount(menuItemsRequest.getDiscount())
                .build();
    }
}