package cl.pago.qr.app.pago.services;

import cl.pago.qr.app.pago.exceptions.PagoAlreadyApprovedException;
import cl.pago.qr.app.pago.exceptions.PagoAlreadyRejectedException;
import cl.pago.qr.app.pago.exceptions.PagoNotFoundException;
import cl.pago.qr.app.pago.models.PagoDto;

public interface PagoService {
    PagoDto obtenerPago(Integer idTrx) throws PagoNotFoundException;
    void aprobarPago(Integer idTrx) throws PagoNotFoundException, PagoAlreadyApprovedException, PagoAlreadyRejectedException;
    void rechazarPago(Integer idTrx)  throws PagoNotFoundException, PagoAlreadyApprovedException, PagoAlreadyRejectedException;
}
