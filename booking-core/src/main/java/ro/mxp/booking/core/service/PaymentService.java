package ro.mxp.booking.core.service;

import ro.mxp.booking.core.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment createPayment(Payment payment);
    Payment getPaymentById(int id);
    List getAllPayment();
    Payment updatePayment(Payment payment);
    void deletePayment(int id);

}
