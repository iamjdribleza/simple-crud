package com.iamjdribleza.simple_crud.dto;

import java.util.UUID;

public record ManufacturerDto(
    UUID refId,
    String name,
    String description,
    int yearFounded
) {
}
