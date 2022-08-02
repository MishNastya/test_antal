package com.mishustina.test_antal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DocumentRecord {

    private Long id;
    private LocalDate date;
    private String name;
}
