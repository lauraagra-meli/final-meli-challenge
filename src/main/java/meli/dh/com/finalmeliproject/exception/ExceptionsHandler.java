package meli.dh.com.finalmeliproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class ExceptionsHandler {

    @ExceptionHandler(WareHouseNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundWareHouseException(WareHouseNotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Armazem não encontrado.")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundProductException(ProductNotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Produto não encontrado.")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundCategoryException(CategoryNotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Categoria não encontrada.")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.NOT_FOUND);
    }
}
