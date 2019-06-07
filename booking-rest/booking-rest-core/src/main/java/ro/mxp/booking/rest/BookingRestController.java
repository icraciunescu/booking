package ro.mxp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.controller.BookingController;
import ro.mxp.booking.core.entity.Booking;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/booking")
public class BookingRestController {

    @Autowired
    private BookingController bookingController;

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking createBooking(Booking booking) {
        return bookingController.createBooking(booking);
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Booking getBookingById(@PathParam("id") int id) {
        return bookingController.getBookingById(id);
    }

    @Path("/get-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> getAllBooking() {
        return bookingController.getAllBooking();
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking updateBooking(Booking booking) {
        return bookingController.updateBooking(booking);
    }

    @Path(("/delete"))
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBooking(@QueryParam("bookingId") int id) {
        bookingController.deleteBooking(id);
    }

}
