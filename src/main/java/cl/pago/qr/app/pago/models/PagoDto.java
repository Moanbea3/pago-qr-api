package cl.pago.qr.app.pago.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagoDto {
    private Integer idTrx;
    private String tipoTrx;
    private Integer monto;
    private String fecha;
    private String estado;
}
