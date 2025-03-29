package restaurant.com.restaurant.web.mapper;

import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;
import restaurant.com.restaurant.web.dto.CreateUserRequest;

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
}
