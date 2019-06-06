package ro.mxp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Availability;
import ro.mxp.booking.core.service.AvailabilityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/availability")
public class AvailabilityRestService {

    @Autowired
    private AvailabilityService availabilityService;

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Availability createAvailability(Availability availability) {
        return availabilityService.createAvailability(availability);
    }

    @Path("get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Availability getAvailabilityById(@PathParam("id") int id) {
        return availabilityService.getAvailabilityById(id);
    }

    @Path("get-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Availability> getAllAvailability() {
        return availabilityService.getAllAvailability();
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Availability updateAvailability(Availability availability) {
        return availabilityService.updateAvailability(availability);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAvailability(@QueryParam("availabilityId") int id) {
        availabilityService.deleteAvailability(id);
    }

}
