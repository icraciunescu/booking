package ro.mxp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.controller.RatingController;
import ro.mxp.booking.core.entity.Rating;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/rating")
public class RatingRestController {

    @Autowired
    private RatingController ratingController;

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rating createRating(Rating rating) {
        return ratingController.createRating(rating);
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Rating getRatingById(@PathParam("id") int id) {
        return ratingController.getRatingById(id);
    }

    @Path("/get-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rating> getAllRating() {
        return ratingController.getAllRating();
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rating updateRating(Rating rating) {
        return ratingController.updateRating(rating);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteRating(@QueryParam("ratingId") int id) {
        ratingController.deleteRating(id);
    }

}
