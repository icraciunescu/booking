package ro.mxp.booking.core.entity;

import ro.mxp.booking.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "host", schema = "booking")
public class Host extends BaseEntity {

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "mail", length = 45, nullable = false)
    private String mail;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return Objects.equals(name, host.name) &&
                Objects.equals(mail, host.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail);
    }

    @Override
    public String toString() {
        return "Host{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

}
