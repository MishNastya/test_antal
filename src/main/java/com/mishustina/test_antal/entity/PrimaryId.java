package com.mishustina.test_antal.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class PrimaryId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "all-generator")
    @SequenceGenerator(name = "all-generator" ,sequenceName = "test_seq", allocationSize = 1)
    private Long id;
}
