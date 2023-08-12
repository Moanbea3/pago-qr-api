package cl.pago.qr.app.pago.controllers;

import cl.pago.qr.app.pago.model.PagoDto;
import cl.pago.qr.app.pago.services.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @Operation(summary = "Obtiene el pago por su id de transacción")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Encuentra el pago solicitado por el id",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PagoDto.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontro el pago solicitado",
                    content = @Content
            )
    })
    @GetMapping("/{idTrx}")
    public PagoDto obtenerPago(@PathVariable Integer idTrx) {
        return pagoService.obtenerPago(idTrx);
    }

    @Operation(summary = "Intenta aprobar el pago solicitado por su id de transacción")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El pago se ha aprobado exitosamente",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PagoDto.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontro el pago a aprobar",
                    content = @Content
            )
    })
    @PutMapping("/{idTrx}/aprobar")
    public PagoDto aprobarPago(@PathVariable Integer idTrx) {
        return pagoService.aprobarPago(idTrx);
    }

    @Operation(summary = "Intenta aprobar el pago solicitado por su id de transacción")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El pago se ha rechazado exitosamente",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PagoDto.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontro el pago a rechazar",
                    content = @Content
            )
    })
    @PutMapping("/{idTrx}/rechazar")
    public PagoDto rechazarPago(@PathVariable Integer idTrx) {
        return pagoService.rechazarPago(idTrx);
    }
}
