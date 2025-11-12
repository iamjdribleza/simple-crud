package com.iamjdribleza.simple_crud.model;

import com.iamjdribleza.simple_crud.enums.GuitarType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public class Guitar {

    private String brand;
    private String model;
    private String color;
    private int strings;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GuitarType type;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @CreationTimestamp
    private LocalDateTime localDateTime;
}