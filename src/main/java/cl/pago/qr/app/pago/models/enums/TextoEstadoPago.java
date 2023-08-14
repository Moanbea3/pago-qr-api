package cl.pago.qr.app.pago.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextoEstadoPago {
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado");
    private final String value;
}
