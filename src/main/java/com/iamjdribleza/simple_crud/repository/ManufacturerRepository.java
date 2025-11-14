package com.iamjdribleza.simple_crud.repository;

import com.iamjdribleza.simple_crud.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Optional<Manufacturer> findByRefId(UUID refId);
    Optional<Manufacturer> findByNameAndYearFounded(String name, int yearFounded);
}
