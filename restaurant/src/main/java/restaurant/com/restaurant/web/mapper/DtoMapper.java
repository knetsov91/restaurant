package restaurant.com.restaurant.web.mapper;

import restaurant.com.restaurant.employeeInfo.model.EmployeeInfo;
import restaurant.com.restaurant.user.model.User;
import restaurant.com.restaurant.web.dto.CreateEmployeeInfoRequest;
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

    public static EmployeeInfo mapCreateEmployeeInfoRequestToEmployeeInfo(CreateEmployeeInfoRequest createEmployeeInfoRequest) {

        return EmployeeInfo
                .builder()
                .age(createEmployeeInfoRequest.getAge())
                .salary(createEmployeeInfoRequest.getSalary())
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
}
