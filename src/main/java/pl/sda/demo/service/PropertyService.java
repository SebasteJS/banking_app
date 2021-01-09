package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.PropertyDto;
import pl.sda.demo.model.Property;
import pl.sda.demo.repository.PropertyRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public Long add(PropertyDto propertyDto) {
        Property property1 = Property.builder()
                .price(propertyDto.getPrice())
                .isPrimaryMarket(propertyDto.isPrimaryMarket())
                .isOwnership(propertyDto.getIsOwnership())
                .isFlat(propertyDto.getIsFlat())
                .build();
        propertyRepository.save(property1);
        return propertyRepository.save(property1).getId();
    }

    public List<PropertyDto> findAll() {
        List<PropertyDto> propertyDtoUser = new ArrayList<>();
        Iterable<Property> properties = propertyRepository.findAll();
        for (Property properties2 : properties) {
            propertyDtoUser.add(
                    PropertyDto.builder()
                            .price(properties2.getPrice())
                            .isPrimaryMarket(properties2.isPrimaryMarket())
                            .isOwnership(properties2.getIsOwnership())
                            .isFlat(properties2.getIsFlat())
                            .build());
        }
        return propertyDtoUser;


    }
}
