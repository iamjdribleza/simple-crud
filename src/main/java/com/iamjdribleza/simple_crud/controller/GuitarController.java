package com.iamjdribleza.simple_crud.controller;

import com.iamjdribleza.simple_crud.dto.GuitarDto;
import com.iamjdribleza.simple_crud.service.GuitarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@RestController
@RequestMapping("api/v1/guitars")
public class GuitarController {

    private final GuitarService guitarService;

    /**
     * GET  /api/v1/guitars
     * Gets all guitars for both acoustic and electric
     *
     * @return ResponseEntity with list of guitars and HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<GuitarDto>> getAllGuitars(){
        return ResponseEntity.ok(guitarService.getAllGuitars());
    }

    /**
     * GET  /api/v1/guitars/{refId}   -   where {refId} is a random UUID
     * Gets specific guitar using reference id
     *
     * @param refId - reference id of the guitar
     * @return
     */
    @GetMapping("/{refId}")
    public ResponseEntity<GuitarDto> getGuitar(@PathVariable UUID refId){
        return ResponseEntity.ok(guitarService.getGuitar(refId));
    }

    /**
     * POST  /api/v1/guitars
     * Creates a new guitar
     *
     * @param guitarDto details of the guitar to be created
     * @return saved Guitar entity
     */
    @PostMapping
    public ResponseEntity<String> createGuitar(@RequestBody GuitarDto guitarDto){
        UUID refId = guitarService.createGuitar(guitarDto);
        URI location = URI.create("/api/v1/guitars/"+refId.toString());

        return ResponseEntity.created(location).body(refId.toString());
    }

    /**
     * PATCH /api/v1/guitars/{refId}   -   where {refId} is a random UUID
     * Updates an existing record
     *
     * @param refId guitar reference id
     * @param guitarDto new details to replace the existing data
     * @return HttpStatus 204
     */
    @PatchMapping("/{refId}")
    public ResponseEntity<Void> updateGuitar(@PathVariable UUID refId,
                                             @RequestBody GuitarDto guitarDto){
        guitarService.updateGuitar(refId, guitarDto);

        return ResponseEntity.noContent().build(); // HttpStatus 204
    }

    /**
     * DELETE /api/v1/guitars/{refId}   -   where {refId} is a random UUID
     * Deletes a guitar
     *
     * @param refId guitar reference id
     * @return HttpStatus 204
     */
    @DeleteMapping("/{refId}")
    public ResponseEntity<Void> deleteGuitar(@PathVariable UUID refId){
        guitarService.deleteGuitar(refId);

        return ResponseEntity.noContent().build(); // HttpStatus 204
    }
}
