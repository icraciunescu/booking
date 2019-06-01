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
import ro.mxp.booking.core.entity.Client;
import ro.mxp.booking.core.entity.Host;
import ro.mxp.booking.core.entity.Property;
import ro.mxp.booking.core.entity.Rating;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class RatingControllerTest {

    @Autowired
    @Qualifier("ratingController")
    private RatingController ratingController;

    @Autowired
    @Qualifier("clientController")
    private ClientController clientController;

    @Autowired
    @Qualifier("propertyController")
    private PropertyController propertyController;

    @Autowired
    @Qualifier("hostController")
    private HostController hostController;

    @Test
    @Rollback
    public void testCreateRating() {
        Rating rating = new Rating();
        rating.setComment("commentTest");
        Client client = new Client();
        client.setName("clientName");
        client.setPhone("0000000123");
        client.setMail("client@client.com");
        clientController.createClient(client);
        rating.setClient(client);
        Property property = new Property();
        property.setName("propertyName");
        property.setAddress("propertyAddress");
        property.setMail("property@property.com");
        Host host = new Host();
        host.setName("hostName");
        host.setMail("host@host.com");
        hostController.createHost(host);
        property.setHost(host);
        propertyController.createProperty(property);
        rating.setProperty(property);
        ratingController.createRating(rating);
        System.out.println(rating.toString());
        Assert.assertNotNull(rating.getProperty());
    }

    @Test
    @Rollback
    public void testGetRatingById() {
        Rating rating = ratingController.getRatingById(1);
        System.out.println(rating.toString());
        Assert.assertNotNull(rating);
    }

    @Test
    @Rollback
    public void testGetAllRating() {
        List<Rating> ratingList = ratingController.getAllRating();
        int actual = ratingList.size();
        Rating rating = new Rating();
        rating.setComment("testComment");
        Client client = new Client();
        client.setName("nameClient");
        client.setMail("client@testclient.com");
        client.setPhone("1234567899");
        clientController.createClient(client);
        rating.setClient(client);
        Property property = new Property();
        property.setName("propertyName");
        property.setAddress("propertyAdress");
        property.setMail("property@propertymail.com");
        property.setPhone("0000123000");
        Host host = new Host();
        host.setName("hostName");
        host.setMail("host@hostmail.com");
        hostController.createHost(host);
        property.setHost(host);
        propertyController.createProperty(property);
        rating.setProperty(property);
        ratingController.createRating(rating);
        List<Rating> ratingList2 = ratingController.getAllRating();
        int expected = ratingList2.size() - 1;
        System.out.println(ratingList2.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testUpdateRating() {
        Rating ratingFromDb = ratingController.getRatingById(1);
        ratingFromDb.setComment("newComment");
        ratingController.createRating(ratingFromDb);
        String actual = ratingFromDb.getComment();
        String expected = "newComment";
        System.out.println(ratingFromDb.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testDeleteRating() {
        List<Rating> ratingList = ratingController.getAllRating();
        int actual = ratingList.size();
        Rating rating = ratingController.getRatingById(1);
        ratingController.deleteRating(rating);
        List<Rating> ratingList2 = ratingController.getAllRating();
        int expected = ratingList2.size() + 1;
        System.out.println(ratingList2.toString());
        Assert.assertEquals(expected, actual);
    }

}
