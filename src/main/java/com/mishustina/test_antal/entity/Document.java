package com.mishustina.test_antal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Document extends PrimaryId {

    private LocalDate date;
    private String name;

    public Document (String name){
        this.name = name;
    }

    public Document() {

    }
}
