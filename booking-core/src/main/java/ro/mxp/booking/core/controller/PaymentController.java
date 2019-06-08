package ro.mxp.booking.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Payment;
import ro.mxp.booking.core.service.PaymentService;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public Payment createPayment(Payment payment) {
        return paymentService.createPayment(payment);
    }

    public Payment getPaymentById(int id) {
        return paymentService.getPaymentById(id);
    }

    public List<Payment> getAllPayment() {
        return paymentService.getAllPayment();
    }

    public Payment updatePayment(Payment payment) {
        return paymentService.updatePayment(payment);
    }

    public void deletePayment(int id) {
        paymentService.deletePayment(id);
    }

}
