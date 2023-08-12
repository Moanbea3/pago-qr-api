package cl.pago.qr.app.pago.services.impl;

import cl.pago.qr.app.pago.mapper.PagoMapper;
import cl.pago.qr.app.pago.model.Pago;
import cl.pago.qr.app.pago.model.PagoDto;
import cl.pago.qr.app.pago.model.enums.EstadoPago;
import cl.pago.qr.app.pago.model.enums.TextoEstadoPago;
import cl.pago.qr.app.pago.repository.PagoRepository;
import cl.pago.qr.app.pago.services.PagoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    public PagoServiceImpl(PagoRepository pagoRepository, PagoMapper pagoMapper) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public PagoDto obtenerPago(Integer idTrx) throws NoSuchElementException {
        Pago pago = pagoRepository.findById(idTrx).orElseThrow();
        return pagoMapper.toDto(pago);
    }

    @Override
    public PagoDto aprobarPago(Integer idTrx) throws NoSuchElementException {
        Pago pago = pagoRepository.findById(idTrx).orElseThrow();
        pago.setCodRespuesta(EstadoPago.APROBADO.getEstado());
        pago.setEstado(TextoEstadoPago.APROBADO.getEstado());
        return pagoMapper.toDto(pagoRepository.save(pago));
    }

    @Override
    public PagoDto rechazarPago(Integer idTrx) throws NoSuchElementException {
        Pago pago = pagoRepository.findById(idTrx).orElseThrow();
        pago.setCodRespuesta(EstadoPago.RECHAZADO.getEstado());
        pago.setEstado(TextoEstadoPago.RECHAZADO.getEstado());
        return pagoMapper.toDto(pagoRepository.save(pago));
    }
}
