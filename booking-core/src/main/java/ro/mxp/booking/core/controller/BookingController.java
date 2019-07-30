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

    /**
     * run the code until booking.getAvailability is equal to availability.getId
     * test RoomType
     * if the conditions are respected create the booking and send it to the client
     * @param booking
     * @return the booking
     */
    public Booking createBooking(@NotNull Booking booking) {
        Booking bookingReturn;
        bookingReturn = booking;
        List<Availability> availabilityList =
                availabilityController.findAvailabilityByFromDateLessThanEqualAndToDateGreaterThanEqual(booking.getCheckIn(), booking.getCheckOut());
        if (availabilityList != null) {
            for (Availability availability : availabilityList) {
                int find = 0;
                do {
                    int x;
                    x = availability.getId();
                    Availability bookingAvailability = booking.getAvailability();
                    if (bookingAvailability == availabilityController.getAvailabilityById(x)) {
                        if (booking.getRoomType().equals(String.valueOf(RoomType.DOUBLE)) &&
                                availability.getRoomType().equals(String.valueOf(RoomType.SINGLE))) {
                            System.out.println("Do not find room type!");
                            System.out.println(booking.getRoomType());
                            bookingReturn = null;
                        } else {
                            System.out.println("I find availabilities");
                            System.out.println("availability id = " + x);
                            bookingReturn = booking;
                            bookingService.createBooking(bookingReturn);
                            bookingService.sendBookingMail(booking, availability);
                            find = find + 1;
                            availabilityController.availabilityAfterBooking(booking);
                        }
                    } else {
                        System.out.println("I do not find availabilities");
                        bookingReturn = null;
                    }
                } while (find == 1);
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
