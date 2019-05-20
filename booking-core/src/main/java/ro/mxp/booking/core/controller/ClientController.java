package ro.mxp.booking.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Client;
import ro.mxp.booking.core.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    public Client createClient(Client client) {
        return clientService.createClient(client);
    }

    public Client getClientById(int id) {
        return clientService.getClientById(id);
    }

    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    public Client updateClient(Client client) {
        return clientService.updateClient(client);
    }

    public void deleteClient(Client client) {
        clientService.deleteClient(client);
    }

}
