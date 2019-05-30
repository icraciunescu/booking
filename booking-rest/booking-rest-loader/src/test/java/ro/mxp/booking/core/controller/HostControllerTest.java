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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class HostControllerTest {

    @Autowired
    @Qualifier("hostController")
    private HostController hostController;

    @Test
    @Rollback
    public void testCreateHost() {
        Host host = new Host();
        host.setName("testHost");
        host.setMail("testhost@testhost.com");
        hostController.createHost(host);
        System.out.println(host.toString());
        Assert.assertNotNull(host.getName());
    }

    @Test
    @Rollback
    public void testGetHostById() {
        Host host = hostController.getHostById(1);
        int actual = host.getId();
        int expected = 1;
        System.out.println(host.toString());
        Assert.assertEquals(expected,actual);
    }

    @Test
    @Rollback
    public void testGetAllHost() {
        List<Host> hostList = hostController.getAllHost();
        int actual = hostList.size();
        Host host = new Host();
        host.setName("newTestHost");
        host.setMail("newtesthost@testhost.com");
        hostController.createHost(host);
        List<Host> hostList2 = hostController.getAllHost();
        int expected = hostList2.size();
        System.out.println(hostList2.toString());
        Assert.assertEquals(expected, actual + 1);
    }

    @Test
    @Rollback
    public void testUpdateHost() {
        Host host = hostController.getHostById(1);
        host.setName("newTestHost");
        hostController.updateHost(host);
        String actual = host.getName();
        String expected = "newTestHost";
        System.out.println(host.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testDeleteHost() {
        List<Host> hostList = hostController.getAllHost();
        int actual = hostList.size();
        Host hostFromDb = hostController.getHostById(1);
        hostController.deleteHost(hostFromDb);
        List<Host> hostList2 = hostController.getAllHost();
        int expected = hostList2.size();
        System.out.println(hostList2.toString());
        Assert.assertEquals(expected, actual - 1);
    }

}
