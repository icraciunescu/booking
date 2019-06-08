package ro.mxp.booking.core.service;

import ro.mxp.booking.core.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking);
    Booking getBookingById(int id);
    List<Booking> getAllBooking();
    Booking updateBooking(Booking booking);
    void deleteBooking(int id);

}
