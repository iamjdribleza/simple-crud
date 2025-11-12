package com.iamjdribleza.simple_crud.model;

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
}
