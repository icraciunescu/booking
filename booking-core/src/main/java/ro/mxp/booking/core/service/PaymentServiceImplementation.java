package ro.mxp.booking.core.service;

import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Payment;

import java.util.List;

@Service("paymentServiceImplementation")
public class PaymentServiceImplementation implements PaymentService {

    @Override
    public Payment createPayment(Payment payment) {
        return null;
    }

    @Override
    public Payment getPaymentById(int id) {
        return null;
    }

    @Override
    public List getAllPayment() {
        return null;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return null;
    }

    @Override
    public void deletePayment(Payment payment) {

    }

}
