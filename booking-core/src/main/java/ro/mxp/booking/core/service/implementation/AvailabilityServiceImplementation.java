package ro.mxp.booking.core.service.implementation;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.commons.DateUtil;
import ro.mxp.booking.core.controller.AvailabilityController;
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.entity.Booking;
import ro.mxp.booking.core.repository.AvailabilityRepository;
import ro.mxp.booking.core.service.AvailabilityService;

import java.util.Date;
import java.util.List;

@Service("availabilityServiceImplementation")
public class AvailabilityServiceImplementation implements AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private AvailabilityController availabilityController;

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

    @Override
    public void availabilityAfterBooking(@NotNull Booking booking) {
        Availability availabilityBooking = booking.getAvailability();
        Date fromBooking = booking.getCheckIn();
        Date toBooking = booking.getCheckOut();
        Date fromBookingExtractOneDay = DateUtil.addDays(fromBooking,-1);
        Date toBookingAddOneDay = DateUtil.addDays(toBooking,1);
        boolean isFound = false;
        if (availabilityBooking.getFromDate().compareTo(fromBooking) < 0) {
            isFound = true;
            if(fromBooking.compareTo(fromBookingExtractOneDay) < 0) {
                Availability newAvailability = new Availability();
                newAvailability.setProperty(availabilityBooking.getProperty());
                newAvailability.setRoomNumber(availabilityBooking.getRoomNumber());
                newAvailability.setPriceSingle(availabilityBooking.getPriceSingle());
                newAvailability.setPriceDouble(availabilityBooking.getPriceDouble());
                newAvailability.setRoomType(availabilityBooking.getRoomType());
                newAvailability.setFromDate(availabilityBooking.getFromDate());
                newAvailability.setToDate(fromBookingExtractOneDay);
                availabilityController.createAvailability(newAvailability);
            }
        }
        if (availabilityBooking.getToDate().compareTo(toBooking) > 0) {
            isFound = true;
            if(toBookingAddOneDay.compareTo(toBooking) > 0) {
                Availability newAvailability = new Availability();
                newAvailability.setProperty(availabilityBooking.getProperty());
                newAvailability.setRoomNumber(availabilityBooking.getRoomNumber());
                newAvailability.setPriceSingle(availabilityBooking.getPriceSingle());
                newAvailability.setPriceDouble(availabilityBooking.getPriceDouble());
                newAvailability.setRoomType(availabilityBooking.getRoomType());
                newAvailability.setFromDate(toBookingAddOneDay);
                newAvailability.setToDate(availabilityBooking.getToDate());
                availabilityController.createAvailability(newAvailability);
            }
        }
        if (isFound) {
            System.out.println("id availability for update = " + availabilityBooking.getId());
            availabilityBooking.setFromDate(fromBooking);
            availabilityBooking.setToDate(toBooking);
            availabilityController.updateAvailability(availabilityBooking);
            System.out.println("if isFound test ok!");
        }
    }
}

