package cl.pago.qr.app.pago.exceptions;

public class PagoAlreadyRejectedException extends RuntimeException {
    public PagoAlreadyRejectedException() {
        super("El pago solicitado ya se encuentra rechazado");
    }
}
