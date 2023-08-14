package cl.pago.qr.app.exceptions;

import cl.pago.qr.app.pago.exceptions.PagoAlreadyApprovedException;
import cl.pago.qr.app.pago.exceptions.PagoAlreadyRejectedException;
import cl.pago.qr.app.pago.exceptions.PagoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PagoNotFoundException.class)
    public ResponseEntity<ApiError> handlePagoNotFound(PagoNotFoundException ex) {
        ApiError error = ApiError.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(PagoAlreadyApprovedException.class)
    public ResponseEntity<ApiError> handlePagoAlreadyApproved(PagoAlreadyApprovedException ex) {
        ApiError error = ApiError.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .badRequest()
                .body(error);
    }

    @ExceptionHandler(PagoAlreadyRejectedException.class)
    public ResponseEntity<ApiError> handlePagoAlreadyRejected(PagoAlreadyRejectedException ex) {
        ApiError error = ApiError.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .badRequest()
                .body(error);
    }
}
