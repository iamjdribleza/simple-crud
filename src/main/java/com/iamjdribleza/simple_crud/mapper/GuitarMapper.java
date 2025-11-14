package com.iamjdribleza.simple_crud.mapper;

import com.iamjdribleza.simple_crud.dto.GuitarDto;
import com.iamjdribleza.simple_crud.model.Guitar;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuitarMapper {
    List<GuitarDto> guitarsToGuitarDtos(List<Guitar> guitars);
    Guitar guitarDtoToGuitar(GuitarDto guitarDto);
    GuitarDto guitarToGuitarDto(Guitar guitar);
    void updateGuitarFromGuitarDto(GuitarDto guitarDto, @MappingTarget Guitar guitar);
}
