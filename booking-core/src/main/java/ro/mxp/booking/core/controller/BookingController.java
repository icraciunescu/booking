package ro.mxp.booking.core.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.entity.Booking;
import ro.mxp.booking.core.enums.RoomType;
import ro.mxp.booking.core.service.BookingService;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AvailabilityController availabilityController;

    public Booking createBooking(@NotNull Booking booking) {
        Booking bookingReturn;
        bookingReturn = booking;
        List<Availability> availabilityList =
                availabilityController.findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(booking.getCheckIn(), booking.getCheckOut());
        if (availabilityList != null) {
            for (Availability availability : availabilityList) {
                if(booking.getRoomType().equals(String.valueOf(RoomType.DOUBLE)) &&
                        availability.getRoomType().equals(String.valueOf(RoomType.SINGLE))) {
                    System.out.println("Do not find room type!");
                    System.out.println(booking.getRoomType());
                    bookingReturn = null;
                } else {
                    int x;
                    x = availability.getId();
                    Availability bookingAvailability = booking.getAvailability();
                    if (bookingAvailability == availabilityController.getAvailabilityById(x)) {
                        System.out.println("I find availabilities");
                        System.out.println("availability id = " + x);
                        bookingReturn = booking;
                        bookingService.createBooking(bookingReturn);
                        availabilityController.availabilityAfterBooking(booking);
                        sendBookingMail(booking, availability);
                    } else {
                        System.out.println("I do not find availabilities");
                        bookingReturn = null;
                    }
                }
            }
        } return bookingReturn;
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

    public void sendBookingMail(Booking booking, Availability availability) {
        bookingService.sendBookingMail(booking, availability);
    }

}
