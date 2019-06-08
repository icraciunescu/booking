package ro.mxp.booking.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Booking;
import ro.mxp.booking.core.service.BookingService;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    public Booking createBooking(Booking booking) {
        return bookingService.createBooking(booking);
    }

    public Booking getBookingById(int id) {
        return bookingService.getBookingById(id);
    }

    public List<Booking> getAllBooking() {
        return bookingService.getAllBooking();
    }

    public Booking updateBooking(Booking booking) {
        return bookingService.updateBooking(booking);
    }

    public void deleteBooking(int id) {
        bookingService.deleteBooking(id);
    }

}
