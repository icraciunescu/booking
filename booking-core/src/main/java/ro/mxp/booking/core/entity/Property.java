package ro.mxp.booking.core.entity;

import ro.mxp.booking.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "property", schema = "booking")
public class Property extends BaseEntity {

    @Column(name = "name", length = 45, nullable = false)
    public String name;

    @Column(name = "mail", length = 45, nullable = true)
    public String mail;

    @Column(name = "phone", length = 15, nullable = true)
    public String phone;

    @Column(name = "adress", length = 45, nullable = false)
    public String adress;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    public Host host;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(name, property.name) &&
                Objects.equals(mail, property.mail) &&
                Objects.equals(phone, property.phone) &&
                Objects.equals(adress, property.adress) &&
                Objects.equals(host, property.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, phone, adress, host);
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", host=" + host +
                '}';
    }

}
