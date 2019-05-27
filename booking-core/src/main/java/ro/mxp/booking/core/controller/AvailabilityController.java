package ro.mxp.booking.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.service.AvailabilityService;

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

    public List getAllAvailability() {
        return availabilityService.getAllAvailability();
    }

    public Availability updateAvailability(Availability availability) {
        return availabilityService.updateAvailability(availability);
    }

    public void deleteAvailability(Availability availability) {
        availabilityService.deleteAvailability(availability);
    }

}
