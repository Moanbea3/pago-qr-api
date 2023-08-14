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
    public PagoDto aprobarPago(Integer idTrx) {
        Pago pago = pagoRepository.findByTrx(idTrx).orElseThrow(() -> new PagoNotFoundException(idTrx));
        checkEstadoPagoIsStillPendiente(pago.getEstado());
        pago.setCodRespuesta(EstadoPago.APROBADO.getEstado());
        pago.setEstado(TextoEstadoPago.APROBADO.getEstado());
        return pagoMapper.toDto(pagoRepository.save(pago));
    }

    @Override
    public PagoDto rechazarPago(Integer idTrx) {
        Pago pago = pagoRepository.findByTrx(idTrx).orElseThrow(() -> new PagoNotFoundException(idTrx));
        checkEstadoPagoIsStillPendiente(pago.getEstado());
        pago.setCodRespuesta(EstadoPago.RECHAZADO.getEstado());
        pago.setEstado(TextoEstadoPago.RECHAZADO.getEstado());
        return pagoMapper.toDto(pagoRepository.save(pago));
    }

    private void checkEstadoPagoIsStillPendiente(String estadoPago) {
        if (estadoPago.equalsIgnoreCase(TextoEstadoPago.APROBADO.getEstado())) {
            throw new PagoAlreadyApprovedException();
        }

        if (estadoPago.equalsIgnoreCase(TextoEstadoPago.RECHAZADO.getEstado())) {
            throw new PagoAlreadyRejectedException();
        }
    }
}
