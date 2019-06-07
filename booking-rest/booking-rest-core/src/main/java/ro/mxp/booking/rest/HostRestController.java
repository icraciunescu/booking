package ro.mxp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.controller.HostController;
import ro.mxp.booking.core.entity.Host;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/host")
public class HostRestController {

    @Autowired
    private HostController hostController;

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Host createHost(Host host) {
        return hostController.createHost(host);
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Host getHostById(@PathParam("id") int id) {
        return hostController.getHostById(id);
    }

    @Path("/get-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Host> getAllHost() {
        return hostController.getAllHost();
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Host updateHost(Host host) {
        return hostController.updateHost(host);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteHost(@QueryParam("hostId") int id) {
        hostController.deleteHost(id);
    }

}
