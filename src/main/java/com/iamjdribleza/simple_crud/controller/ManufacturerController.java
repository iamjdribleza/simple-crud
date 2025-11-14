package com.iamjdribleza.simple_crud.controller;

import com.iamjdribleza.simple_crud.dto.ManufacturerDto;
import com.iamjdribleza.simple_crud.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    /**
     * GET /api/v1/manufacturers
     * Gets all manufacturers
     *
     * @return ResponseEntity with all manufacturers and HttpStatus 200
     */
    @GetMapping
    public ResponseEntity<List<ManufacturerDto>> getAllManufacturers(){
        return ResponseEntity.ok(manufacturerService.getAllManufacturers());
    }

    /**
     * GET /api/v1/manufacturers/{refId}
     * Gets specific manufacturer using reference id
     *
     * @param refId manufacturer's reference id
     * @return manufacturer's details
     */
    @GetMapping("/{refId}")
    public ResponseEntity<ManufacturerDto> getManufacturer(@PathVariable UUID refId){
        return ResponseEntity.ok(manufacturerService.getManufacturer(refId));
    }

    /**
     * POST /api/v1/manufacturers
     * Creates a new Manufacturer
     *
     * @param manufacturerDto manufacturers details to be saved
     * @return newly created manufacturer's details
     */
    @PostMapping
    public ResponseEntity<ManufacturerDto> createManufacturer(@RequestBody ManufacturerDto manufacturerDto){
        ManufacturerDto savedManufacturer = manufacturerService.createManufacturer(manufacturerDto);

        // Create location for client purposes
        URI location = URI.create("/api/v1/manufacturers/"+savedManufacturer.refId());

        return ResponseEntity.created(location).body(savedManufacturer);
    }

    /**
     * PATCH /api/v1/manufacturers/{refId}
     * Updates a manufacturer's details using reference id
     *
     * @param refId manufacturer's reference id
     * @param manufacturerDto manufacturer's new details to replace the existing data
     * @return ResponseEntity with HttpStatus 204
     */
    @PatchMapping("/{refId}")
    public ResponseEntity<Void> updateManufacturer(@PathVariable UUID refId,
                                                   @RequestBody ManufacturerDto manufacturerDto){
        manufacturerService.updateManufacturer(refId, manufacturerDto);

        return ResponseEntity.noContent().build();
    }

    /**
     * DELETE /api/v1/manufaturers/{refId}
     * Deletes manufacturer's record using reference id
     *
     * @param refId manufacturer's reference id
     * @return ResponseEntity with HttpStatus 204
     */
    @DeleteMapping("/{refId}")
    public ResponseEntity<Void> deleteManufacturer(@PathVariable UUID refId){
        manufacturerService.deleteManufacturer(refId);

        return ResponseEntity.noContent().build();
    }
}
