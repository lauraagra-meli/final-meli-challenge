package meli.dh.com.finalmeliproject.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter @Getter
@Builder
public class ExceptionDetails {
    private String title;
    private String message;
    private LocalDateTime timestamp;
}
