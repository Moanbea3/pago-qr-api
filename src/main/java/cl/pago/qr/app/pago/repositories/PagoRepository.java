package cl.pago.qr.app.pago.repositories;

import cl.pago.qr.app.pago.models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    Optional<Pago> findByTrx(Integer trx);
}
