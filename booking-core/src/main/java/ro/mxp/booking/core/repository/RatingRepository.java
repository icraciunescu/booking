package ro.mxp.booking.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mxp.booking.core.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
