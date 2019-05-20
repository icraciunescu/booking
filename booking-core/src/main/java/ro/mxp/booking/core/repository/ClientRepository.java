package ro.mxp.booking.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mxp.booking.core.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
