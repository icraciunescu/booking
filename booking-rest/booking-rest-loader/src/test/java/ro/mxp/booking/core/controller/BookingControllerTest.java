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
    @Qualifier("hostController")
    private HostController hostController;

    @Autowired
    @Qualifier("propertyController")
    private PropertyController propertyController;

    @Autowired
    @Qualifier("availabilityController")
    private AvailabilityController availabilityController;

    @Test
    @Rollback(false)
    public void testCreateBooking() {
        Booking booking = new Booking();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, Calendar.MAY, 3);
        Date checkIn = calendar.getTime();
        booking.setCheckIn(checkIn);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(0);
        calendar2.set(2019, Calendar.MAY, 4);
        Date checkOut = calendar2.getTime();
        booking.setCheckOut(checkOut);
        booking.setNumberOfPersons(1);
        booking.setRoomType(String.valueOf(RoomType.SINGLE));
        booking.setNumberOfRooms(1);
        Client client = new Client();
        client.setName("clientName");
        client.setPhone("0000123456");
        client.setMail("client@client.com");
        clientController.createClient(client);
        booking.setClient(client);
        Property property = new Property();
        property.setName("propertyName");
        property.setAddress("propertyAddress");
        property.setMail("property@property.com");
        property.setPhone("0000000123");
        Host host = new Host();
        host.setName("hostName");
        host.setMail("host@host.com");
        hostController.createHost(host);
        property.setHost(host);
        propertyController.createProperty(property);
        booking.setProperty(property);
        Availability availability = availabilityController.getAvailabilityById(3);
        booking.setAvailability(availability);
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
