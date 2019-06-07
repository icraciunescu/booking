package ro.mxp.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.controller.PaymentController;
import ro.mxp.booking.core.entity.Payment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/payment")
public class PaymentRestController {

    @Autowired
    private PaymentController paymentController;

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Payment createPayment(Payment payment) {
        return paymentController.createPayment(payment);
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Payment getPaymentById(@PathParam("id") int id) {
        return paymentController.getPaymentById(id);
    }

    @Path("/get-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getAllPayment() {
        return paymentController.getAllPayment();
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Payment updatePayment(Payment payment) {
        return paymentController.updatePayment(payment);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePayment(@QueryParam("paymentId") int id) {
        paymentController.deletePayment(id);
    }

}
