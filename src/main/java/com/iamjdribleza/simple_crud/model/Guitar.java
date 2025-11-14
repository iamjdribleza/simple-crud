package com.iamjdribleza.simple_crud.model;

import com.iamjdribleza.simple_crud.enums.GuitarType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Guitar {

    @Id
    @SequenceGenerator(
            name = "guitar_seq_gen",
            sequenceName = "guitar_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guitar_seq_gen")
    private long id;

    @Column(unique = true, updatable = false)
    private UUID refId;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String[] colors;

    @Column(nullable = false)
    private int strings;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GuitarType type;

    @Column(nullable = false, updatable = false)
    private UUID manufacturerRefId;

    @CreationTimestamp
    private LocalDateTime dateCreated;
}