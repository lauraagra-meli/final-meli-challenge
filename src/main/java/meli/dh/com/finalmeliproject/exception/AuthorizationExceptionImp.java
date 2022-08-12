package meli.dh.com.finalmeliproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthorizationExceptionImp extends RuntimeException{
    public AuthorizationExceptionImp(String message){
        super(message);
    }
}
