package ro.mxp.booking.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mxp.booking.core.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
