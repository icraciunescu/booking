package ro.mxp.booking.core.repository;

import ro.mxp.booking.core.base.MyBaseRepository;
import ro.mxp.booking.core.entity.Availability;

import java.util.Date;
import java.util.List;

public interface AvailabilityRepository extends MyBaseRepository<Availability, Integer> {

    List<Availability> findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(Date fromDate, Date toDate);

}
