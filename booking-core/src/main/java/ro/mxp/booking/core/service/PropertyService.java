package ro.mxp.booking.core.service;

import ro.mxp.booking.core.entity.Property;

import java.util.List;

public interface PropertyService {

    Property createProperty(Property property);
    Property getPropertyById(int id);
    List<Property> getAllProperty();
    Property updateProperty(Property property);
    void deleteProperty(int id);

}
