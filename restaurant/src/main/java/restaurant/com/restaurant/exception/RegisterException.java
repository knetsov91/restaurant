package restaurant.com.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RegisterException extends RuntimeException {
    public RegisterException(String message) {
        super(message);
    }
}
