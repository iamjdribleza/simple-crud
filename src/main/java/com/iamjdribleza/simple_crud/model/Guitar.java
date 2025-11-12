package com.iamjdribleza.simple_crud.model;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class Guitar {
    private String brand;
    private String model;
    private String color;
    private int strings;
    private String description;
    private Manufacturer manufacturer;

    @CreationTimestamp
    private LocalDateTime localDateTime;
}