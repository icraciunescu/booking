package ro.mxp.booking.core.service.implementation;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mxp.booking.core.entity.Property;
import ro.mxp.booking.core.repository.PropertyRepository;
import ro.mxp.booking.core.service.PropertyService;

import java.util.List;

@Service("propertyServiceImplementation")
public class PropertyServiceImplementation implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyById(int id) {
        return propertyRepository.findOne(id);
    }

    @Override
    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    @Override
    public Property updateProperty(@NotNull Property property) {
        Property propertyFromDb = propertyRepository.findOne(property.getId());
        return propertyRepository.save(propertyFromDb);
    }

    @Override
    public void deleteProperty(int id) {
        propertyRepository.delete(id);
    }

}
