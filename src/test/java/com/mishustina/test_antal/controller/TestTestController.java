package com.mishustina.test_antal.controller;

import com.mishustina.test_antal.SortOrder;
import com.mishustina.test_antal.dto.DictionaryRecord;
import com.mishustina.test_antal.dto.DocumentRecord;
import com.mishustina.test_antal.dto.TestRecord;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestTestController {

    @Autowired
    private TestController testController;

    @Test
    @Ignore
    public void createTest() {
        testController.createTest(createTestRecord());
    }

    @Test
    @Ignore
    public void deleteTest() {
        testController.deleteTest(8L);
    }

    @Test
    @Ignore
    public void updateTest() {
        TestRecord testRecord = createTestRecord();
        testRecord.setId(17L);
        testRecord.getDictionaryRecord().setId(18L);
        testRecord.getDocumentRecord().setId(19L);
        testRecord.setName("Test2");
        testController.updateTest(testRecord);
    }

    private TestRecord createTestRecord(){
        TestRecord testRecord = new TestRecord();
        testRecord.setName("name");
        testRecord.setSortOrder(SortOrder.ASC.name());
        testRecord.setDocumentRecord(createDocumentRecord());
        testRecord.setDictionaryRecord(createDictionaryRecord());
        return testRecord;
    }

    private static DocumentRecord createDocumentRecord(){
        DocumentRecord documentRecord = new DocumentRecord();
        documentRecord.setName("document name");
        documentRecord.setDate(LocalDate.now());
        return documentRecord;
    }

    private static DictionaryRecord createDictionaryRecord(){
        DictionaryRecord dictionaryRecord = new DictionaryRecord();
        dictionaryRecord.setName("dictionary name");
        return dictionaryRecord;

    }
}
