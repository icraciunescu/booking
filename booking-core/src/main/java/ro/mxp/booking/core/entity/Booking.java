package ro.mxp.booking.core.entity;

import ro.mxp.booking.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "booking", schema = "booking")
public class Booking extends BaseEntity {

    @Column(name = "check_in", length = 10, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date checkIn;

    @Column(name = "check_out", length = 10, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date checkOut;

    @Column(name = "number_of_persons", length = 3, nullable = false)
    private int numberOfPersons;

    @Column(name = "number_of_rooms", length = 3, nullable = false)
    private int numberOfRooms;

    @Column(name = "room_type", length = 10, nullable = false)
    private String roomType;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @OneToOne
    @JoinColumn(name = "availlability", nullable = false)
    private Availability availability;

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return numberOfPersons == booking.numberOfPersons &&
                numberOfRooms == booking.numberOfRooms &&
                Objects.equals(checkIn, booking.checkIn) &&
                Objects.equals(checkOut, booking.checkOut) &&
                Objects.equals(roomType, booking.roomType) &&
                Objects.equals(client, booking.client) &&
                Objects.equals(property, booking.property) &&
                Objects.equals(availability, booking.availability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkIn, checkOut, numberOfPersons, numberOfRooms, roomType, client, property, availability);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", numberOfPersons=" + numberOfPersons +
                ", numberOfRooms=" + numberOfRooms +
                ", roomType='" + roomType + '\'' +
                ", client=" + client +
                ", property=" + property +
                ", availability=" + availability +
                '}';
    }

}
