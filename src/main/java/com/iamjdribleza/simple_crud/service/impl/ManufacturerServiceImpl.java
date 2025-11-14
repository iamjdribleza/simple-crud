package com.iamjdribleza.simple_crud.service.impl;

import com.iamjdribleza.simple_crud.dto.ManufacturerDto;
import com.iamjdribleza.simple_crud.enums.HttpErrorResponseType;
import com.iamjdribleza.simple_crud.exception.ResourceAlreadyExists;
import com.iamjdribleza.simple_crud.exception.ResourceNotFoundException;
import com.iamjdribleza.simple_crud.mapper.ManufacturerMapper;
import com.iamjdribleza.simple_crud.model.Manufacturer;
import com.iamjdribleza.simple_crud.repository.ManufacturerRepository;
import com.iamjdribleza.simple_crud.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Transactional(rollbackFor = ResourceAlreadyExists.class)
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    /**
     * Retrieves all Manufacturers from the database
     *
     * @return list of manufacturers
     */
    @Override
    public List<ManufacturerDto> getAllManufacturers() {
        return manufacturerMapper.manufacturersToManufacturerDtos(manufacturerRepository.findAll());
    }

    /**
     * Retrieves specific manufacturer using reference id
     *
     * @param refId manufacturer's reference id
     * @throws ResourceNotFoundException if manufacturer is not found
     * @return manufacturer's details
     */
    @Override
    public ManufacturerDto getManufacturer(UUID refId) {
        return manufacturerRepository.findByRefId(refId)
                .map(manufacturerMapper::manufacturerToManufacturerDto)
                .orElseThrow(() -> new ResourceNotFoundException(HttpErrorResponseType.RESOURCE_NOT_FOUND.name()));
    }

    /**
     * Creates new manufacturer and inserts into the database
     *
     * @param manufacturerDto manufacturers details to be created and saved
     * @return the newly created manufacturer details
     * @throws ResourceAlreadyExists if manufacturer is already exists
     */
    @Override
    public ManufacturerDto createManufacturer(ManufacturerDto manufacturerDto) {

        // Check database if manufacturer is already in the records
        boolean manufacturerAlreadyExists = manufacturerRepository.findByNameAndYearFounded(manufacturerDto.name(), manufacturerDto.yearFounded())
                .isPresent();

        // Test if manufacturer already exists and throw exception if it does
        if (manufacturerAlreadyExists) throw new ResourceAlreadyExists(HttpErrorResponseType.RESOURCE_ALREADY_EXISTS.name());

        // If manufacturer doesn't exist, then create a new instance of Manufacturer
        Manufacturer manufacturer = new Manufacturer();

        // Map details to the new instance
        manufacturerMapper.updateManufacturerFromManufacturerDto(manufacturerDto, manufacturer);
        manufacturer.setRefId(UUID.randomUUID());

        // Save manufacturer to the database
        Manufacturer savedManufacturer = manufacturerRepository.save(manufacturer);

        return manufacturerMapper.manufacturerToManufacturerDto(savedManufacturer);
    }

    /**
     * Update manufacturers details
     *
     * @param refId manufacturers reference id
     * @param manufacturerDto manufacturers new details to replace the existing data
     * @throws ResourceNotFoundException if no manufacturer found using the reference id
     */
    @Override
    public void updateManufacturer(UUID refId, ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = manufacturerRepository.findByRefId(refId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpErrorResponseType.RESOURCE_NOT_FOUND.name()));

        // Update existing manufacturer's details
        manufacturerMapper.updateManufacturerFromManufacturerDto(manufacturerDto, manufacturer);

        // Save new manufacturer's details
        manufacturerRepository.save(manufacturer);
    }

    /**
     * Deletes a manufacturer's record from the database
     *
     * @param refId manufacturers reference id
     */
    @Override
    public void deleteManufacturer(UUID refId) {
        Manufacturer manufacturer = manufacturerRepository.findByRefId(refId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpErrorResponseType.RESOURCE_NOT_FOUND.name()));

        manufacturerRepository.delete(manufacturer);
    }
}
