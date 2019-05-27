package ro.mxp.booking.core.service;

import ro.mxp.booking.core.entity.Availability;

import java.util.List;

public interface AvailabilityService {

    Availability createAvailability(Availability availability);
    Availability getAvailabilityById(int id);
    List getAllAvailability();
    Availability updateAvailability(Availability availability);
    void deleteAvailability(Availability availability);

}
