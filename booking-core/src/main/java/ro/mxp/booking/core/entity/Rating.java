package ro.mxp.booking.core.entity;

import ro.mxp.booking.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rating", schema = "booking")
public class Rating extends BaseEntity {

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(comment, rating.comment) &&
                Objects.equals(property, rating.property) &&
                Objects.equals(client, rating.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, property, client);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "comment='" + comment + '\'' +
                ", property=" + property +
                ", client=" + client +
                '}';
    }

}
