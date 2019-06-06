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
public class PaymentControllerTest {

    @Autowired
    @Qualifier("paymentController")
    private PaymentController paymentController;

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
    @Qualifier("hostController")
    private HostController hostController;

    @Autowired
    @Qualifier("availabilityController")
    private AvailabilityController availabilityController;

    @Test
    @Rollback
    public void testCreatePayment() {
        Payment payment = new Payment();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019,Calendar.MAY, 5);
        Date paymentDate = calendar.getTime();
        payment.setPaymentDate(paymentDate);
        payment.setAmount(new BigDecimal(125));
        Booking booking = new Booking();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(0);
        calendar2.set(2019, Calendar.MAY, 2);
        Date checkIn = calendar2.getTime();
        booking.setCheckIn(checkIn);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(0);
        calendar3.set(2019, Calendar.MAY, 12);
        Date checkOut = calendar3.getTime();
        booking.setCheckOut(checkOut);
        booking.setNumberOfRooms(1);
        booking.setNumberOfPersons(2);
        booking.setRoomType(String.valueOf(RoomType.DOUBLE));
        Client client = new Client();
        client.setName("clientName");
        client.setMail("client@mailclient.com");
        client.setPhone("0000123000");
        clientController.createClient(client);
        booking.setClient(client);
        Property property = new Property();
        property.setName("propertyName");
        property.setAddress("propertyAddress");
        property.setMail("property@property.com");
        property.setPhone("1234567899");
        Host host = new Host();
        host.setName("hostName");
        host.setMail("host@host.com");
        hostController.createHost(host);
        property.setHost(host);
        propertyController.createProperty(property);
        booking.setProperty(property);
        Availability availability = new Availability();
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTimeInMillis(0);
        calendar4.set(2019, Calendar.MAY, 1);
        Date fromDate = calendar4.getTime();
        availability.setFromDate(fromDate);
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTimeInMillis(0);
        calendar5.set(2019, Calendar.MAY, 29);
        Date toDate = calendar5.getTime();
        availability.setToDate(toDate);
        availability.setRoomNumber(5);
        availability.setRoomType(String.valueOf(RoomType.DOUBLE));
        availability.setPriceSingle(new BigDecimal(120));
        availability.setPriceDouble(new BigDecimal(175));
        availability.setProperty(property);
        availabilityController.createAvailability(availability);
        booking.setAvailability(availability);
        bookingController.createBooking(booking);
        payment.setBooking(booking);
        paymentController.createPayment(payment);
        System.out.println(payment.toString());
        Assert.assertNotNull(payment.getBooking());
    }

    @Test
    @Rollback
    public void testGetPaymentById() {
        Payment payment = paymentController.getPaymentById(1);
        int actual = payment.getId();
        int expected = 1;
        System.out.println(payment.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testGetAllPayment() {
        List<Payment> paymentList = paymentController.getAllPayment();
        int actual = paymentList.size();
        paymentController.deletePayment(2);
        List<Payment> paymentList2 = paymentController.getAllPayment();
        int expected = paymentList2.size() + 1;
        System.out.println(paymentList2.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testUpdatePayment() {
        Payment paymentFromDb = paymentController.getPaymentById(1);
        paymentFromDb.setAmount(new BigDecimal(75));
        paymentController.updatePayment(paymentFromDb);
        BigDecimal actual = paymentFromDb.getAmount();
        BigDecimal expected = new BigDecimal(75);
        System.out.println(paymentFromDb.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testDeletePayment() {
        List<Payment> paymentList = paymentController.getAllPayment();
        int actual = paymentList.size();
        paymentController.deletePayment(2);
        List<Payment> paymentList2 = paymentController.getAllPayment();
        int expected = paymentList2.size() + 1;
        System.out.println(paymentList2.toString());
        Assert.assertEquals(expected, actual);
    }

}
