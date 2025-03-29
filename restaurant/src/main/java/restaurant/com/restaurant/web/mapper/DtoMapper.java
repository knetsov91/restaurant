package restaurant.com.restaurant.web.mapper;

import restaurant.com.restaurant.employeeInfo.model.EmployeeInfo;
import restaurant.com.restaurant.web.dto.CreateEmployeeRequest;
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


    public static EmployeeInfo mapCreateEmployeeRequestToEmployeeInfo(CreateEmployeeRequest createEmployeeRequest) {

        return EmployeeInfo
                .builder()
                .age(createEmployeeRequest.getAge())
                .salary(createEmployeeRequest.getSalary())
                .hireDate(LocalDateTime.now())
                .build();
    }
}
