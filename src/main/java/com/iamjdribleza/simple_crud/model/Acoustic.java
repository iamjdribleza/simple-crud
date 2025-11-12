package com.iamjdribleza.simple_crud.model;

import com.iamjdribleza.simple_crud.enums.GuitarType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity(name = "tbl_acoustic")
public class Acoustic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acoustic_seq")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GuitarType type;
}
