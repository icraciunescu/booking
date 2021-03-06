package ro.mxp.booking.core.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.mxp.booking.core.entity.*;
import ro.mxp.booking.core.enums.RoomType;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class BookingControllerTest {

    @Autowired
    @Qualifier("bookingController")
    private BookingController bookingController;

    @Autowired
    @Qualifier("clientController")
    private ClientController clientController;

    @Autowired
    @Qualifier("propertyController")
    private PropertyController propertyController;

    @Autowired
    @Qualifier("availabilityController")
    private AvailabilityController availabilityController;

    @Test
    @Rollback
    public void testCreateBooking() {
        Booking booking = new Booking();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, Calendar.JUNE, 20);
        Date checkIn = calendar.getTime();
        booking.setCheckIn(checkIn);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(0);
        calendar2.set(2019, Calendar.JUNE, 24);
        Date checkOut = calendar2.getTime();
        booking.setCheckOut(checkOut);
        booking.setNumberOfPersons(1);
        booking.setRoomType(String.valueOf(RoomType.DOUBLE));
        booking.setNumberOfRooms(1);
        Availability availability = availabilityController.getAvailabilityById(15);
        booking.setAvailability(availability);
        Client client = new Client();
        client.setName("clientName");
        client.setPhone("0000123456");
        client.setMail("icraciunescu@hotmail.com");
        clientController.createClient(client);
        booking.setClient(client);
        Property property = propertyController.getPropertyById(availability.getProperty().getId());
        booking.setProperty(property);
        bookingController.createBooking(booking);
        Assert.assertNotNull(booking.getClient());
    }

    @Test
    @Rollback
    public void testGetBookingById() {
        Booking booking = bookingController.getBookingById(1);
        int actual = booking.getId();
        int expected = 1;
        System.out.println(booking.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testGetAllBooking() {
        List<Booking> bookingList = bookingController.getAllBooking();
        int actual = bookingList.size();
        bookingController.deleteBooking(4);
        List<Booking> bookingList2 = bookingController.getAllBooking();
        int expected = bookingList2.size() + 1;
        System.out.println(bookingList2.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testUpdateBooking() {
        Booking bookingFromDb = bookingController.getBookingById(1);
        bookingFromDb.setNumberOfPersons(1);
        bookingController.updateBooking(bookingFromDb);
        int actual = bookingFromDb.getNumberOfPersons();
        int expected = 1;
        System.out.println(bookingFromDb.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testDeleteBooking() {
        List<Booking> bookingList = bookingController.getAllBooking();
        int actual = bookingList.size();
        bookingController.deleteBooking(4);
        List<Booking> bookingList2 = bookingController.getAllBooking();
        int expected = bookingList2.size() + 1;
        System.out.println(bookingList2.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testSendBookingMail() {
        Booking booking = bookingController.getBookingById(3);
        Availability availability = availabilityController.getAvailabilityById(3);
        bookingController.sendBookingMail(booking, availability);
    }

}
