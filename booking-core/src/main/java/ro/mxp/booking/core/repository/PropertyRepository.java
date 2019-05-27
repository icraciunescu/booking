package ro.mxp.booking.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mxp.booking.core.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
