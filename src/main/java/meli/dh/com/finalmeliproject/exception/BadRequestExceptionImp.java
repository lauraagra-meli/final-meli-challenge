package meli.dh.com.finalmeliproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExceptionImp extends RuntimeException{
    public BadRequestExceptionImp(String message){
        super(message);
    }
}
