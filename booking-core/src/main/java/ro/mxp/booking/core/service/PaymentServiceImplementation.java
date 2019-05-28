package ro.mxp.booking.core.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Payment;
import ro.mxp.booking.core.repository.PaymentRepository;

import java.util.List;

@Service("paymentServiceImplementation")
public class PaymentServiceImplementation implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentRepository.findOne(id);
    }

    @Override
    public List getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(@NotNull Payment payment) {
        Payment paymentFromDb = paymentRepository.findOne(payment.getId());
        return paymentRepository.save(paymentFromDb);
    }

    @Override
    public void deletePayment(Payment payment) {
        paymentRepository.delete(payment);
    }

}
