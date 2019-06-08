package ro.mxp.booking.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.mxp.booking.core.entity.Property;
import ro.mxp.booking.core.service.PropertyService;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    public Property createProperty(Property property) {
        return propertyService.createProperty(property);
    }

    public Property getPropertyById(int id) {
        return propertyService.getPropertyById(id);
    }

    public List<Property> getAllProperty() {
        return propertyService.getAllProperty();
    }

    public Property updateProperty(Property property) {
        return propertyService.updateProperty(property);
    }

    public void deleteProperty(int id) {
        propertyService.deleteProperty(id);
    }

}
