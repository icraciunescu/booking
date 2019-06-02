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
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.entity.Host;
import ro.mxp.booking.core.entity.Property;
import ro.mxp.booking.core.enums.RoomType;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class AvailabilityControllerTest {

    @Autowired
    @Qualifier("availabilityController")
    private AvailabilityController availabilityController;

    @Autowired
    @Qualifier("hostController")
    private HostController hostController;

    @Autowired
    @Qualifier("propertyController")
    private PropertyController propertyController;

    @Test
    @Rollback(false)
    public void testCreateAvailability() {
        Availability availability = new Availability();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019,Calendar.MAY, 01);
        Date fromDate = calendar.getTime();
        availability.setFromDate(fromDate);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(0);
        calendar2.set(2019,Calendar.MAY, 28);
        Date toDate = calendar2.getTime();
        availability.setToDate(toDate);
        availability.setRoomType(String.valueOf(RoomType.SINGLE));
        availability.setRoomNumber(1);
        availability.setPriceSingle(new BigDecimal(100));
        availability.setPriceDouble(new BigDecimal(100));
        Property property = new Property();
        property.setName("propertyName");
        property.setAddress("propertyAddress");
        property.setMail("property@property.com");
        property.setPhone("0000123456");
        Host host = new Host();
        host.setName("hostName");
        host.setMail("host@host.com");
        hostController.createHost(host);
        property.setHost(host);
        propertyController.createProperty(property);
        availability.setProperty(property);
        availabilityController.createAvailability(availability);
        System.out.println(availability.toString());
        Assert.assertNotNull(availability.getProperty());
    }

    @Test
    @Rollback
    public void testGetAvailabilityById() {
        Availability availability = availabilityController.getAvailabilityById(2);
        int actual = availability.getId();
        int expected = 2;
        System.out.println(availability.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testGetAllAvailability() {
        List<Availability> availabilityList = availabilityController.getAllAvailability();
        int actual = availabilityList.size();
        Availability availability = availabilityController.getAvailabilityById(2);
        availabilityController.deleteAvailability(availability);
        List<Availability> availabilityList2 = availabilityController.getAllAvailability();
        int expected = availabilityList2.size() + 1;
        System.out.println(availabilityList2.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testUpdateAvailability() {
        Availability availabilityFromDb = availabilityController.getAvailabilityById(2);
        availabilityFromDb.setRoomNumber(2);
        availabilityController.updateAvailability(availabilityFromDb);
        int actual = availabilityFromDb.getRoomNumber();
        int expected = 2;
        System.out.println(availabilityFromDb.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testDeleteAvailability() {
        List<Availability> availabilityList = availabilityController.getAllAvailability();
        int actual = availabilityList.size();
        Availability availability = availabilityController.getAvailabilityById(2);
        availabilityController.deleteAvailability(availability);
        List<Availability> availabilityList2 = availabilityController.getAllAvailability();
        int expected = availabilityList2.size() + 1;
        System.out.println(availabilityList2.toString());
        Assert.assertEquals(expected, actual);
    }

}
