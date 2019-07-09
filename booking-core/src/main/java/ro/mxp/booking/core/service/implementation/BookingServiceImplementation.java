package ro.mxp.booking.core.service.implementation;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.commons.EmailService;
import ro.mxp.booking.core.controller.AvailabilityController;
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.entity.Booking;
import ro.mxp.booking.core.enums.RoomType;
import ro.mxp.booking.core.repository.BookingRepository;
import ro.mxp.booking.core.service.BookingService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.longValue;

@Service("bookingServiceImplementation")
public class BookingServiceImplementation implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AvailabilityController availabilityController;

    private EmailService emailService = new EmailService();

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingRepository.findOne(id);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(@NotNull Booking booking) {
        Booking bookingFromDb = bookingRepository.findOne(booking.getId());
        return bookingRepository.save(bookingFromDb);
    }

    @Override
    public void deleteBooking(int id) {
        bookingRepository.delete(id);
    }

    @Override
    public void sendBookingMail(Booking booking, Availability availability) {

        String message = "Dear " + booking.getClient().getName()
                + "\n"
                + "Thank you for choosing " + booking.getProperty().getName()
                + "."
                + "According to your order, we make a reservation for you as following:"
                + "\n"
                + booking.getNumberOfRooms() + " room(s)"
                + "\n"
                + booking.getRoomType()
                + "\n"
                + "check-in date: " + booking.getCheckIn()
                + "\n"
                + "check-out date: " + booking.getCheckOut()
                + "\n"
                + "price: " + getIntervalBetweenTwoDates(booking.getCheckIn(), booking.getCheckOut()) *
                getRoomPrice(availability, booking) + " RON."
                + "\n"
                + "We are looking forward to have you our guest!";

        String mailAddress = booking.getClient().getMail();

        String subject = "Room reservation for " + booking.getClient().getName();

        int size =availabilityController
                .findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(booking.getCheckIn(), booking.getCheckOut())
                .size();

        if (size == 0) {
            String nonAvailabilityMessage = "Sorry, but I don't have available rooms in the period you choose.";
            emailService.sendEmail(nonAvailabilityMessage, mailAddress, subject);
        } else {
            emailService.sendEmail(message, mailAddress, subject);
        }

    }

    private Long getIntervalBetweenTwoDates(Date firstDate, Date secondDate) {
        Long diff = secondDate.getTime() - firstDate.getTime();
        Long diffDays = diff / (1000 * 60 * 60 * 24);
        return diffDays;
    }

    private Long getRoomPrice(Availability availability, Booking booking) {
        BigDecimal price = null;
        if(booking.getRoomType().equals(String.valueOf(RoomType.SINGLE))) {
            price = availability.getPriceSingle();
        } else  {
            price = availability.getPriceDouble();
        }
        return longValue (price);
    }

}
