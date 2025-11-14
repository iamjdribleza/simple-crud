package com.iamjdribleza.simple_crud.service;

import com.iamjdribleza.simple_crud.dto.ManufacturerDto;

import java.util.List;
import java.util.UUID;

public interface ManufacturerService {
    List<ManufacturerDto> getAllManufacturers();
    ManufacturerDto getManufacturer(UUID refId);
    ManufacturerDto createManufacturer(ManufacturerDto manufacturerDto);
    void updateManufacturer(UUID refId, ManufacturerDto manufacturerDto);
    void deleteManufacturer(UUID refId);
}
