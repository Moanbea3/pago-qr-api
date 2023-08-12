package cl.pago.qr.app.pago.services;

import cl.pago.qr.app.pago.model.PagoDto;

import java.util.NoSuchElementException;

public interface PagoService {
    PagoDto obtenerPago(Integer idTrx) throws NoSuchElementException;
    PagoDto aprobarPago(Integer idTrx) throws NoSuchElementException;
    PagoDto rechazarPago(Integer idTrx) throws NoSuchElementException;
}
