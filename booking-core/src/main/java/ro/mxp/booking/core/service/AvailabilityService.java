package ro.mxp.booking.core.service;

import ro.mxp.booking.core.entity.Availability;

import java.util.Date;
import java.util.List;

public interface AvailabilityService {

    Availability createAvailability(Availability availability);
    Availability getAvailabilityById(int id);
    List<Availability> getAllAvailability();
    Availability updateAvailability(Availability availability);
    void deleteAvailability(int id);

    List<Availability> findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(Date fromDate, Date toDate);

}
