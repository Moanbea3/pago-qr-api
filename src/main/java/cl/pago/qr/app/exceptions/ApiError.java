package cl.pago.qr.app.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ApiError {
    private Integer statusCode;
    private String message;
    private LocalDateTime timestamp;
}
