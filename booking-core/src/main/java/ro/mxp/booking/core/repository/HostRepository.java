package ro.mxp.booking.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mxp.booking.core.entity.Host;

public interface HostRepository extends JpaRepository<Host, Integer> {
}
