package cl.pago.qr.app.pago.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoPago {
    APROBADO(0),
    RECHAZADO(1);
    private final Integer estado;
}


