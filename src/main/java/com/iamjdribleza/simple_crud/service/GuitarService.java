package com.iamjdribleza.simple_crud.service;

import com.iamjdribleza.simple_crud.dto.GuitarDto;

import java.util.List;
import java.util.UUID;

public interface GuitarService {
    List<GuitarDto> getAllGuitars();
    GuitarDto getGuitar(UUID refId);
    UUID createGuitar(GuitarDto guitarDto);
    void updateGuitar(UUID refId, GuitarDto guitarDto);
    void deleteGuitar(UUID refId);
}
