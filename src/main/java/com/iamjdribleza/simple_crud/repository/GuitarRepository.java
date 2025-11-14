package com.iamjdribleza.simple_crud.repository;

import com.iamjdribleza.simple_crud.model.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GuitarRepository extends JpaRepository<Guitar, Long> {
    Optional<Guitar> findByRefId(UUID refId);
    Optional<Guitar> findByBrandAndModel(String brand, String model);
}
