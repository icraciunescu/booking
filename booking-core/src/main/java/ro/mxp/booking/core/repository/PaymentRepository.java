package ro.mxp.booking.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mxp.booking.core.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
