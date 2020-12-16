package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.PropertyDto;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.model.Property;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.role.RoleType;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PropertyService {
    private final pl.sda.demo.repository.PropertyRepository propertyRepository;


    public Long add(PropertyDto propertyDto) {
        Property property1 = Property.builder()
                .price(propertyDto.getPrice())
                .isSecondaryMarket(propertyDto.isSecondaryMarket())
                .isPrimaryMarket(propertyDto.isPrimaryMarket())
                .isOwnership(propertyDto.isOwnership())
                .isCooperativeOwnership(propertyDto.isCooperativeOwnership())
                .isFlat(propertyDto.isFlat())
                .isHouse(propertyDto.isHouse())
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
                            .isSecondaryMarket(properties2.isSecondaryMarket())
                            .isPrimaryMarket(properties2.isPrimaryMarket())
                            .isOwnership(properties2.isOwnership())
                            .isCooperativeOwnership(properties2.isCooperativeOwnership())
                            .isFlat(properties2.isFlat())
                            .isHouse(properties2.isHouse())
                            .build());
        }
        return propertyDtoUser;


    }
}
