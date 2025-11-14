package com.iamjdribleza.simple_crud.dto;

import com.iamjdribleza.simple_crud.enums.GuitarType;

import java.util.UUID;

public record GuitarDto(
    UUID refId,
    String brand,
    String model,
    String description,
    String[] colors,
    int strings,
    GuitarType type,
    UUID manufacturerRefId
) {
}