package com.iamjdribleza.simple_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity(name = "tbl_electric")
public class Electric extends Guitar{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_seq")
    private long id;
}