package ro.mxp.booking.core.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.entity.Booking;
import ro.mxp.booking.core.enums.Reserved;
import ro.mxp.booking.core.service.AvailabilityService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    public Availability createAvailability(Availability availability) {
        return availabilityService.createAvailability(availability);
    }

    public Availability getAvailabilityById(int id) {
        return availabilityService.getAvailabilityById(id);
    }

    public List<Availability> getAllAvailability() {
        return availabilityService.getAllAvailability();
    }

    public Availability updateAvailability(Availability availability) {
        return availabilityService.updateAvailability(availability);
    }

    public void deleteAvailability(int id) {
        availabilityService.deleteAvailability(id);
    }

    /**
     * test the interval between two dates
     * test if the Availability is not reserved for another Client
     * @param fromDate
     * @param toDate
     * @return Availability if the conditions are respected
     */
    public List<Availability> findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(Date fromDate, Date toDate) {
        List<Availability> availabilityList;
        availabilityList = availabilityService.findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(fromDate, toDate);
        List<Availability> noReservedAvailabilityList = new LinkedList<>();
        if(availabilityList != null) {
            for (Availability availability: availabilityList) {
                if (availability.getReserved().equals(String.valueOf(Reserved.NO))) {
                    System.out.println("Find availabilities");
                    noReservedAvailabilityList.add(availability);
                } else {
                    System.out.println("Not found availabilities");
                }
            }
        }
        return noReservedAvailabilityList;
    }

    public void availabilityAfterBooking(Booking booking) {
        availabilityService.availabilityAfterBooking(booking);
    }

}
