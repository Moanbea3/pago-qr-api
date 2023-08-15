package cl.pago.qr.app.pago.services.impl;

import cl.pago.qr.app.pago.exceptions.PagoAlreadyApprovedException;
import cl.pago.qr.app.pago.exceptions.PagoAlreadyRejectedException;
import cl.pago.qr.app.pago.exceptions.PagoNotFoundException;
import cl.pago.qr.app.pago.mappers.PagoMapper;
import cl.pago.qr.app.pago.models.Pago;
import cl.pago.qr.app.pago.models.PagoDto;
import cl.pago.qr.app.pago.models.enums.EstadoPago;
import cl.pago.qr.app.pago.models.enums.TextoEstadoPago;
import cl.pago.qr.app.pago.repositories.PagoRepository;
import cl.pago.qr.app.pago.services.PagoService;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    public PagoServiceImpl(PagoRepository pagoRepository, PagoMapper pagoMapper) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public PagoDto obtenerPago(Integer idTrx) {
        Pago pago = pagoRepository.findByTrx(idTrx).orElseThrow(() -> new PagoNotFoundException(idTrx));
        return pagoMapper.toDto(pago);
    }

    @Override
    public void aprobarPago(Integer idTrx) {
        Pago pago = pagoRepository.findByTrx(idTrx).orElseThrow(() -> new PagoNotFoundException(idTrx));
        checkEstadoPagoIsStillPendiente(pago.getCodRespuesta());
        pago.setCodRespuesta(EstadoPago.APROBADO.getValue());
        pago.setEstado(TextoEstadoPago.APROBADO.getValue());
        pagoRepository.save(pago);
    }

    @Override
    public void rechazarPago(Integer idTrx) {
        Pago pago = pagoRepository.findByTrx(idTrx).orElseThrow(() -> new PagoNotFoundException(idTrx));
        checkEstadoPagoIsStillPendiente(pago.getCodRespuesta());
        pago.setCodRespuesta(EstadoPago.RECHAZADO.getValue());
        pago.setEstado(TextoEstadoPago.RECHAZADO.getValue());
        pagoRepository.save(pago);
    }

    private void checkEstadoPagoIsStillPendiente(Integer estadoPago) {
        if (estadoPago.equals(EstadoPago.APROBADO.getValue())) {
            throw new PagoAlreadyApprovedException();
        }

        if (estadoPago.equals(EstadoPago.RECHAZADO.getValue())) {
            throw new PagoAlreadyRejectedException();
        }
    }
}
