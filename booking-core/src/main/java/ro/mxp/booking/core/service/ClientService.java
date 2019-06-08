package ro.mxp.booking.core.service;

import ro.mxp.booking.core.entity.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);
    Client getClientById(int id);
    List<Client> getAllClient();
    Client updateClient(Client client);
    void deleteClient(int id);

}
