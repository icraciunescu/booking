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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ClientControllerTest {

    @Autowired
    @Qualifier("clientController")
    public ClientController clientController;

    @Test
    @Rollback
    public void testCreateClient() {
        Client client = new Client();
        client.setName("ion craciunescu");
        client.setMail("icraciunescu@hotmail.com");
        client.setPhone("0745 202 778");
        clientController.createClient(client);
        System.out.println(client.toString());
        Assert.assertNotNull(client.getName());
    }

    @Test
    @Rollback
    public void testGetClientById() {
        Client client = clientController.getClientById(3);
        int actual = client.getId();
        int expected = 3;
        System.out.println((client.toString()));
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testGetAllClient() {
        List<Client> clients = clientController.getAllClient();
        int actual = clients.size();
        Client client = new Client();
        client.setName("test");
        client.setMail("test@test.com");
        client.setPhone("0000 000 000");
        clientController.createClient(client);
        System.out.println(client.toString());
        List<Client> clients2 = clientController.getAllClient();
        int expected = clients2.size();
        Assert.assertEquals(expected, actual + 1);
    }

    @Test
    @Rollback
    public void testUpdateClient() {
        Client clientFromDb = clientController.getClientById(3);
        clientFromDb.setName("testName");
        clientFromDb.setMail("testmail@mail.com");
        clientFromDb.setPhone("9999 999 999");
        clientController.createClient(clientFromDb);
        System.out.println(clientFromDb.toString());
        Client expected = clientController.updateClient(clientFromDb);
        Client actual = clientFromDb;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testDeleteClient() {
        List<Client> clients = clientController.getAllClient();
        int actual = clients.size();
        Client clientFromDb = clientController.getClientById(3);
        clientController.deleteClient(clientFromDb);
        List<Client> clients2 = clientController.getAllClient();
        int expected = clients2.size();
        Assert.assertEquals(expected, actual - 1);
    }

}
