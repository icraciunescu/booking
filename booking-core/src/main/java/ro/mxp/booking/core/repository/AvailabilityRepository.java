package ro.mxp.booking.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mxp.booking.core.entity.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
}
