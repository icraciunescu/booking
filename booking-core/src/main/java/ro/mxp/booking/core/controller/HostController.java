package ro.mxp.booking.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Host;
import ro.mxp.booking.core.service.HostService;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    public Host createHost(Host host) {
        return hostService.createHost(host);
    }

    public Host getHostById(int id) {
        return hostService.getHostById(id);
    }

    public List getAllHost() {
        return hostService.getAllHost();
    }

    public Host updateHost(Host host) {
        return hostService.updateHost(host);
    }

    public void deleteHost(Host host) {
        hostService.deleteHost(host);
    }

}
