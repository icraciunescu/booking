package ro.mxp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.controller.PropertyController;
import ro.mxp.booking.core.entity.Property;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/property")
public class PropertyRestController {

    @Autowired
    private PropertyController propertyController;

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Property createProperty(Property property) {
        return propertyController.createProperty(property);
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Property getPropertyById(@PathParam("id") int id) {
        return propertyController.getPropertyById(id);
    }

    @Path("/get-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Property> getAllProperty() {
        return propertyController.getAllProperty();
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Property updateProperty(Property property) {
        return propertyController.updateProperty(property);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteProperty(@QueryParam("propertyId") int id) {
        propertyController.deleteProperty(id);
    }

}
