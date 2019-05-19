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
    private BigDecimal amounth;

    @Column(name = "payment_date", length = 10)
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    public BigDecimal getAmounth() {
        return amounth;
    }

    public void setAmounth(BigDecimal amounth) {
        this.amounth = amounth;
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
        return Objects.equals(amounth, payment.amounth) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(booking, payment.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amounth, paymentDate, booking);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amounth=" + amounth +
                ", paymentDate=" + paymentDate +
                ", booking=" + booking +
                '}';
    }

}
