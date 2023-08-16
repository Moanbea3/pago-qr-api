package cl.pago.qr.app.pago.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "backend")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pago")
    private Integer idPago;

    @Column(name = "ID_llave", nullable = false, length = 100)
    private String idLlave;

    @Column(name = "Id_Sucursal", nullable = false)
    private Integer idSucursal;

    @Column(name = "ID_Pos", nullable = false)
    private Integer idPos;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Cajero", nullable = false)
    private Integer cajero;

    @Column(name = "Trx", nullable = false)
    private Integer trx;

    @Column(name = "Tipo_trx", nullable = false, length = 20)
    private String tipoTrx;

    @Column(name = "Monto", nullable = false)
    private Integer monto;

    @Column(name = "Cod_respuesta", nullable = false)
    private Integer codRespuesta;

    @Column(name = "Estado", nullable = false, length = 20)
    private String estado;
}
