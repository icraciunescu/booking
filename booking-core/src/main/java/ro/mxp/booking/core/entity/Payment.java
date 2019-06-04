package ro.mxp.booking.core.entity;

import ro.mxp.booking.core.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "payment", schema = "booking")
public class Payment extends BaseEntity {

    @Column(name = "amount", length = 10)
    private BigDecimal amount;

    @Column(name = "payment_date", length = 10)
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(amount, payment.amount) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(booking, payment.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentDate, booking);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", booking=" + booking +
                '}';
    }

}
