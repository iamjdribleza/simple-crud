package com.iamjdribleza.simple_crud.model;

import com.iamjdribleza.simple_crud.enums.GuitarType;
import jakarta.persistence.Entity;

@Entity
public class Electric extends Guitar{
    @Override
    public GuitarType getType(){
        return GuitarType.ELECTRIC;
    }
}