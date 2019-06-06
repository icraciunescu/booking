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
import ro.mxp.booking.core.entity.Host;
import ro.mxp.booking.core.entity.Property;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class PropertyControllerTest {

    @Autowired
    @Qualifier("propertyController")
    private PropertyController propertyController;

    @Autowired
    @Qualifier("hostController")
    private HostController hostController;

    @Test
    @Rollback
    public void testCreateProperty() {
        Property property = new Property();
        property.setName("propertyName");
        property.setAddress("propertyAdress");
        property.setMail("property@property.com");
        property.setPhone("0000123456");
        Host host = new Host();
        host.setName("hostName");
        host.setMail("hostmail@hostmail.com");
        hostController.createHost(host);
        property.setHost(host);
        propertyController.createProperty(property);
        System.out.println(property.toString());
        Assert.assertNotNull(property.getName());
    }

    @Test
    @Rollback
    public void testGetPropertyById() {
        Property property = propertyController.getPropertyById(2);
        int expected = property.getId();
        int actual = 2;
        System.out.println(property.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testGetAllProperty() {
        List<Property> propertyList = propertyController.getAllProperty();
        int actual = propertyList.size();
        Property property = new Property();
        property.setName("propertyName");
        property.setAddress("propertyAdress");
        property.setPhone("0000000123");
        property.setMail("property@property.com");
        Host host = new Host();
        host.setName("hostName");
        host.setMail("host@host.com");
        hostController.createHost(host);
        property.setHost(host);
        propertyController.createProperty(property);
        List<Property> propertyList2 = propertyController.getAllProperty();
        int expected = propertyList2.size() - 1;
        System.out.println(propertyList2.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testUpdateProperty() {
        Property propertyFromDb = propertyController.getPropertyById(2);
        propertyFromDb.setName("updateProperty");
        propertyController.updateProperty(propertyFromDb);
        String actual = propertyFromDb.getName();
        String expected = "updateProperty";
        System.out.println(propertyFromDb.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testDeleteProperty() {
        List<Property> propertyList = propertyController.getAllProperty();
        int actual = propertyList.size();
        propertyController.deleteProperty(6);
        List<Property> propertyList2 = propertyController.getAllProperty();
        int expected = propertyList2.size() + 1;
        System.out.println(propertyList2.toString());
        Assert.assertEquals(expected, actual);
    }

}
