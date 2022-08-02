package com.mishustina.test_antal.dto;

import lombok.Data;

@Data
public class TestRecord {

    private Long id;
    private DictionaryRecord dictionaryRecord;
    private DocumentRecord documentRecord;
    private String sortOrder;
    private String name;

}
