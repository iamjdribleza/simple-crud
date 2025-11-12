package com.iamjdribleza.simple_crud.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public class Guitar {

    private String brand;
    private String model;
    private String color;
    private int strings;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @CreationTimestamp
    private LocalDateTime localDateTime;
}