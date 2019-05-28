package ro.mxp.booking.core.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Booking;
import ro.mxp.booking.core.repository.BookingRepository;

import java.util.List;

@Service("bookingServiceImplementation")
public class BookingServiceImplementation implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingRepository.findOne(id);
    }

    @Override
    public List getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(@NotNull Booking booking) {
        Booking bookingFromDb = bookingRepository.findOne(booking.getId());
        return bookingRepository.save(bookingFromDb);
    }

    @Override
    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }

}
