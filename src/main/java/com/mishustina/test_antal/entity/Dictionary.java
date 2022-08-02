package com.mishustina.test_antal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Dictionary extends PrimaryId {

    @Column(name = "name")
    private String valueName;

    public Dictionary (String name){
        this.valueName = name;
    }

    public Dictionary() {

    }
}
