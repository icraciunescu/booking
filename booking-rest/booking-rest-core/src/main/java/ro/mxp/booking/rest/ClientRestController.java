package ro.mxp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.controller.ClientController;
import ro.mxp.booking.core.entity.Client;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/client")
public class ClientRestController {

    @Autowired
    private ClientController clientController;

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Client createClient(Client client) {
        return clientController.createClient(client);
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientById(@PathParam("id") int id) {
        return clientController.getClientById(id);
    }

    @Path("/get-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAllClient() {
        return clientController.getAllClient();
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Client updateClient(Client client) {
        return clientController.updateClient(client);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteClient(@QueryParam("clientId") int id) {
        clientController.deleteClient(id);
    }

}
