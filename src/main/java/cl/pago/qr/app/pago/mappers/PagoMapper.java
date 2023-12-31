package cl.pago.qr.app.pago.mappers;

import cl.pago.qr.app.pago.models.Pago;
import cl.pago.qr.app.pago.models.PagoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagoMapper {
    @Mapping(source = "trx", target = "idTrx")
    @Mapping(target = "fecha", dateFormat = "dd-MM-yyyy")
    PagoDto toDto(Pago source);
}
