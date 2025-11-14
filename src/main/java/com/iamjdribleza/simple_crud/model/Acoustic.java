package com.iamjdribleza.simple_crud.model;

import com.iamjdribleza.simple_crud.enums.GuitarType;
import jakarta.persistence.*;

@Entity
public class Acoustic extends Guitar{
    @Override
    public GuitarType getType(){
        return GuitarType.ACOUSTIC;
    }
}
