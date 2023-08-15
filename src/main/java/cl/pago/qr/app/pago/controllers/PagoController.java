package cl.pago.qr.app.pago.controllers;

import cl.pago.qr.app.exceptions.ApiError;
import cl.pago.qr.app.pago.models.PagoDto;
import cl.pago.qr.app.pago.services.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping("/{idTrx}")
    @Operation(summary = "Obtiene el pago por su id de transacción")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Encuentra el pago solicitado por el id",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PagoDto.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontro el pago",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    public PagoDto obtenerPago(@PathVariable Integer idTrx) {
        return pagoService.obtenerPago(idTrx);
    }

    @PutMapping("/{idTrx}/aprobar")
    @Operation(summary = "Intenta aprobar el pago solicitado por su id de transacción")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El pago se aprueba exitosamente",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "El pago solicitado ya se encuentra aprobado o rechazado",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontro el pago",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    public void aprobarPago(@PathVariable Integer idTrx) {
        pagoService.aprobarPago(idTrx);
    }

    @PutMapping("/{idTrx}/rechazar")
    @Operation(summary = "Intenta aprobar el pago solicitado por su id de transacción")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El pago se rechaza exitosamente",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "El pago solicitado ya se encuentra aprobado o rechazado",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontro el pago",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    public void rechazarPago(@PathVariable Integer idTrx) {
        pagoService.rechazarPago(idTrx);
    }
}
