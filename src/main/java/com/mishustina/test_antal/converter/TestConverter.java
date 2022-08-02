package com.mishustina.test_antal.converter;

import com.mishustina.test_antal.SortOrder;
import com.mishustina.test_antal.dto.DictionaryRecord;
import com.mishustina.test_antal.dto.DocumentRecord;
import com.mishustina.test_antal.dto.TestRecord;
import com.mishustina.test_antal.entity.Dictionary;
import com.mishustina.test_antal.entity.Document;
import com.mishustina.test_antal.entity.Test;

public class TestConverter {

    public static Test convertTestRecordToTest(TestRecord testRecord, Test test) {
        test.setName(testRecord.getName());
        test.setSortOrder(SortOrder.valueOf(testRecord.getSortOrder()));
        test.setId(test.getId());
        return test;
    }

    public static Document convertDocumentRecordToDocument(DocumentRecord documentRecord, Document document){
        document.setId(documentRecord.getId());
        document.setName(documentRecord.getName());
        document.setDate(documentRecord.getDate());
        return document;
    }

    public static Dictionary convertDictionaryRecordToDictionary(DictionaryRecord dictionaryRecord, Dictionary dictionary){
        dictionary.setId(dictionaryRecord.getId());
        dictionary.setValueName(dictionaryRecord.getName());
        return dictionary;
    }

    public static TestRecord convertTestToTestRecord(Test test) {
        TestRecord testRecord = new TestRecord();
        testRecord.setName(test.getName());
        testRecord.setSortOrder(test.getSortOrder().name());
        testRecord.setId(test.getId());
        testRecord.setDocumentRecord(convertDocumentToDocumentRecord(test.getDocument()));
        testRecord.setDictionaryRecord(convertDictionaryToDictionaryRecord(test.getDictionary()));
        return testRecord;
    }

    private static DocumentRecord convertDocumentToDocumentRecord(Document document){
        DocumentRecord documentRecord = new DocumentRecord();
        documentRecord.setId(document.getId());
        documentRecord.setName(document.getName());
        documentRecord.setDate(document.getDate());
        return documentRecord;
    }

    private static DictionaryRecord convertDictionaryToDictionaryRecord(Dictionary dictionary){
        DictionaryRecord dictionaryRecord = new DictionaryRecord();
        dictionaryRecord.setId(dictionary.getId());
        dictionaryRecord.setName(dictionary.getValueName());
        return dictionaryRecord;
    }
}
