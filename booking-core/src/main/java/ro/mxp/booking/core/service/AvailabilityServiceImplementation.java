package ro.mxp.booking.core.service;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.repository.AvailabilityRepository;

import java.util.List;

@Service("availabilityServiceImplementation")
public class AvailabilityServiceImplementation implements AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Override
    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public Availability getAvailabilityById(int id) {
        return availabilityRepository.findOne(id);
    }

    @Override
    public List getAllAvailability() {
        return availabilityRepository.findAll();
    }

    @Override
    public Availability updateAvailability(@NotNull Availability availability) {
        Availability availabilityFromDb = availabilityRepository.findOne(availability.getId());
        return availabilityRepository.save(availabilityFromDb);
    }

    @Override
    public void deleteAvailability(Availability availability) {
        availabilityRepository.delete(availability);
    }

}
