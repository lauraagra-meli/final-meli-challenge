package meli.dh.com.finalmeliproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NotFoundExceptionImp.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundProductException(NotFoundExceptionImp ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Not found")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RepresentativeUnauthorizedException.class)
    public ResponseEntity<ExceptionDetails> handlerRepresentativeUnauthorized(RepresentativeUnauthorizedException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Unauthorized representative")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.UNAUTHORIZED);
    }
}
