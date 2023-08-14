package cl.pago.qr.app.pago.exceptions;

public class PagoAlreadyApprovedException extends RuntimeException {
    public PagoAlreadyApprovedException() {
        super("El pago solicitado ya se encuentra aprobado");
    }
}
