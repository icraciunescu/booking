package ro.mxp.booking.core.entity;

import ro.mxp.booking.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "host", schema = "booking")
public class Host extends BaseEntity {

    @Column(name = "name", length = 45, nullable = false)
    public String name;

    @Column(name = "mail", length = 45, nullable = false)
    public String mail;

}
