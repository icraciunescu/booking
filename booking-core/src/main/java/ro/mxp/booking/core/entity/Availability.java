package ro.mxp.booking.core.entity;

import ro.mxp.booking.core.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "availability", schema = "booking")
public class Availability extends BaseEntity {

    @Column(name = "room_number", length = 3, nullable = false)
    private int roomNumber;

    @Column(name = "from_date", length = 10, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date", length = 10, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @Column(name = "room_type", length = 10, nullable = true)
    private String roomType;

    @Column(name = "price_double", length = 5, nullable = false)
    private BigDecimal priceDouble;

    @Column(name = "price_single", length = 5, nullable = false)
    private BigDecimal priceSingle;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPriceDouble() {
        return priceDouble;
    }

    public void setPriceDouble(BigDecimal priceDouble) {
        this.priceDouble = priceDouble;
    }

    public BigDecimal getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(BigDecimal priceSingle) {
        this.priceSingle = priceSingle;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Availability that = (Availability) o;
        return roomNumber == that.roomNumber &&
                Objects.equals(fromDate, that.fromDate) &&
                Objects.equals(toDate, that.toDate) &&
                Objects.equals(roomType, that.roomType) &&
                Objects.equals(priceDouble, that.priceDouble) &&
                Objects.equals(priceSingle, that.priceSingle) &&
                Objects.equals(property, that.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, fromDate, toDate, roomType, priceDouble, priceSingle, property);
    }

    @Override
    public String toString() {
        return "Availability{" +
                "roomNumber=" + roomNumber +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", roomType='" + roomType + '\'' +
                ", priceDouble=" + priceDouble +
                ", priceSingle=" + priceSingle +
                ", property=" + property +
                '}';
    }

}
