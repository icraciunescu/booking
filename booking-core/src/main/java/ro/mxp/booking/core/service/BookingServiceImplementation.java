package ro.mxp.booking.core.service;

import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Booking;

import java.util.List;

@Service("bookingServiceImplementation")
public class BookingServiceImplementation implements BookingService {

    @Override
    public Booking createBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking getBookingById(int id) {
        return null;
    }

    @Override
    public List getAllBooking() {
        return null;
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return null;
    }

    @Override
    public void deleteBooking(Booking booking) {

    }

}
