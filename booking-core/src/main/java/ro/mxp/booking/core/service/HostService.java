package ro.mxp.booking.core.service;

import ro.mxp.booking.core.entity.Host;

import java.util.List;

public interface HostService {

    Host createHost(Host host);
    Host getHostById(int id);
    List getAllHost();
    Host updateHost(Host host);
    void deleteHost(int id);

}
