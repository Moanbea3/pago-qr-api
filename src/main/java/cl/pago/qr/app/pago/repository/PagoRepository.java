package cl.pago.qr.app.pago.repository;

import cl.pago.qr.app.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PagoRepository extends JpaRepository<Pago, Integer> {}
