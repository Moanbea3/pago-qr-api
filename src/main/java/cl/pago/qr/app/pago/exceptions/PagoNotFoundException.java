package cl.pago.qr.app.pago.exceptions;

public class PagoNotFoundException extends RuntimeException {
    public PagoNotFoundException(Integer idTrx) {
        super(String.format("El pago con id transacción %d no existe", idTrx));
    }
}
