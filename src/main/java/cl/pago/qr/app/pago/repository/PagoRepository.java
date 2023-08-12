package cl.pago.qr.app.pago.repository;

import cl.pago.qr.app.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    Optional<Pago> findByTrx(Integer trx);
}
