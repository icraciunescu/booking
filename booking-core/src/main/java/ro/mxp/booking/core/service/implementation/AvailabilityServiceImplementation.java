package ro.mxp.booking.core.service.implementation;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.repository.AvailabilityRepository;
import ro.mxp.booking.core.service.AvailabilityService;

import java.util.Date;
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
    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    @Override
    public Availability updateAvailability(@NotNull Availability availability) {
        Availability availabilityFromDb = availabilityRepository.findOne(availability.getId());
        return availabilityRepository.save(availabilityFromDb);
    }

    @Override
    public void deleteAvailability(int id) {
        availabilityRepository.delete(id);
    }

    @Override
    public List<Availability> findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(Date fromDate, Date toDate) {
        return availabilityRepository.findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(fromDate, toDate);
    }

}
