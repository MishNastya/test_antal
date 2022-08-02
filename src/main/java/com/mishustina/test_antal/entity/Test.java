package com.mishustina.test_antal.entity;

import com.mishustina.test_antal.SortOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Test extends PrimaryId {

    @Column
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Document document;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Dictionary dictionary;

    @Column
    @Enumerated(EnumType.STRING)
    private SortOrder sortOrder;

    public Test(Document document, Dictionary dictionary) {
        this.dictionary = dictionary;
        this.document = document;
    }

    protected Test() {

    }
}
