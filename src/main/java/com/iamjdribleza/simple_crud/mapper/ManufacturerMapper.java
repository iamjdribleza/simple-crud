package com.iamjdribleza.simple_crud.mapper;

import com.iamjdribleza.simple_crud.dto.ManufacturerDto;
import com.iamjdribleza.simple_crud.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    Manufacturer manufacturerDtoToManufacturer(ManufacturerDto manufacturerDto);
    ManufacturerDto manufacturerToManufacturerDto(Manufacturer manufacturer);
    List<ManufacturerDto> manufacturersToManufacturerDtos(List<Manufacturer> manufacturers);
    void updateManufacturerFromManufacturerDto(ManufacturerDto manufacturerDto, @MappingTarget Manufacturer manufacturer);
}
