package meli.dh.com.finalmeliproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class RepresentativeUnauthorizedException extends RuntimeException {

    public RepresentativeUnauthorizedException(String message) {
        super(message);
    }
}
