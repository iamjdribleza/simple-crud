package com.iamjdribleza.simple_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Manufacturer {
    @Id
    @SequenceGenerator(
            name = "manufacturer_seq_gen",
            sequenceName = "manufacturer_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_seq_gen")
    private long id;

    @Column(updatable = false, unique = true)
    private UUID refId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int yearFounded;

    @CreationTimestamp
    private LocalDate dateCreated;
}
