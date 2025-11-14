package com.iamjdribleza.simple_crud.service.impl;

import com.iamjdribleza.simple_crud.dto.GuitarDto;
import com.iamjdribleza.simple_crud.enums.GuitarType;
import com.iamjdribleza.simple_crud.enums.HttpErrorResponseType;
import com.iamjdribleza.simple_crud.exception.ResourceAlreadyExists;
import com.iamjdribleza.simple_crud.exception.ResourceNotFoundException;
import com.iamjdribleza.simple_crud.mapper.GuitarMapper;
import com.iamjdribleza.simple_crud.model.Acoustic;
import com.iamjdribleza.simple_crud.model.Electric;
import com.iamjdribleza.simple_crud.model.Guitar;
import com.iamjdribleza.simple_crud.repository.GuitarRepository;
import com.iamjdribleza.simple_crud.service.GuitarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Transactional(rollbackFor = ResourceAlreadyExists.class)
@Service
public class GuitarServiceImpl implements GuitarService {

    private final GuitarRepository guitarRepository;
    private final GuitarMapper guitarMapper;

    /**
     * Retrieves all guitars
     * @return a list of all guitars, including both acoustic and electric
     */
    @Override
    public List<GuitarDto> getAllGuitars() {
        return guitarMapper.guitarsToGuitarDtos(guitarRepository.findAll());
    }

    /**
     * Retrieves specific guitar using reference ID
     * @param refId - Guitars reference id
     * @return a single guitar
     */
    @Override
    public GuitarDto getGuitar(UUID refId) {
        return guitarRepository.findByRefId(refId)
                .map(guitarMapper::guitarToGuitarDto)
                .orElseThrow(() -> new ResourceNotFoundException(HttpErrorResponseType.RESOURCE_NOT_FOUND.name()));
    }

    /**
     * Inserts guitar to the database, checks if entity already exists before inserting data
     * @param guitarDto - Guitar details to be saved
     * @throws ResourceAlreadyExists if a guitar with the same brand and model already exists
     */
    @Override
    public UUID createGuitar(GuitarDto guitarDto) {

        // Create instance according to type
        Guitar guitar = guitarDto.type() == GuitarType.ELECTRIC? new Electric(): new Acoustic();

        // Map dto to new guitar instance
        guitarMapper.updateGuitarFromGuitarDto(guitarDto, guitar);

        // Check database if brand + model already exists
        boolean guitarAlreadyExists = guitarRepository.findByBrandAndModel(guitar.getBrand(), guitar.getModel())
                .isPresent();

        // check if guitar already exists on the database
        if (guitarAlreadyExists) throw new ResourceAlreadyExists(HttpErrorResponseType.RESOURCE_ALREADY_EXISTS.name());

        // set reference id with random UUID
        guitar.setRefId(UUID.randomUUID());

        Guitar savedGuitar = guitarRepository.save(guitar);

        // return reference id
        return savedGuitar.getRefId();
    }

    /**
     * Updates a record on the database
     *
     * @param refId Guitar's reference id
     * @param guitarDto new data to replace existing records
     */
    @Override
    public void updateGuitar(UUID refId, GuitarDto guitarDto) {
        Guitar guitar = guitarRepository.findByRefId(refId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpErrorResponseType.RESOURCE_NOT_FOUND.name()));

        // Update existing record using mapper
        guitarMapper.updateGuitarFromGuitarDto(guitarDto, guitar);

        guitarRepository.save(guitar);
    }

    /**
     * Deletes a record from the database, checks if entity already exists before deleting
     *
     * @param refId Guitar's reference id
     * @throws ResourceNotFoundException if guitar is not found
     */
    @Override
    public void deleteGuitar(UUID refId) {
        Guitar guitar = guitarRepository.findByRefId(refId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpErrorResponseType.RESOURCE_NOT_FOUND.name()));

        guitarRepository.delete(guitar);
    }
}
