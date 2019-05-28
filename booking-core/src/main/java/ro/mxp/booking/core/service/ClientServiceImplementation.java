package ro.mxp.booking.core.service;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Client;
import ro.mxp.booking.core.repository.ClientRepository;

import java.util.List;

@Service("clientServiceImplementation")
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(int id) {
        return clientRepository.findOne(id);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(@NotNull Client client) {
        Client clientFromDb = clientRepository.findOne(client.getId());
        return clientRepository.save(clientFromDb);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

}
