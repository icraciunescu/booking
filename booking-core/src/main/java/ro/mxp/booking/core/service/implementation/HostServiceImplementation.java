package ro.mxp.booking.core.service.implementation;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Host;
import ro.mxp.booking.core.repository.HostRepository;
import ro.mxp.booking.core.service.HostService;

import java.util.List;

@Service("hostServiceImplementation")
public class HostServiceImplementation implements HostService {

    @Autowired
    private HostRepository hostRepository;

    @Override
    public Host createHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Host getHostById(int id) {
        return hostRepository.findOne(id);
    }

    @Override
    public List<Host> getAllHost() {
        return hostRepository.findAll();
    }

    @Override
    public Host updateHost(@NotNull Host host) {
        Host hostFromDb = hostRepository.findOne(host.getId());
        return hostRepository.save(hostFromDb);
    }

    @Override
    public void deleteHost(int id) {
        hostRepository.delete(id);
    }

}
