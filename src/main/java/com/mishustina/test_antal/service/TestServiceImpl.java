package com.mishustina.test_antal.service;

import com.mishustina.test_antal.converter.TestConverter;
import com.mishustina.test_antal.dto.TestRecord;
import com.mishustina.test_antal.entity.Dictionary;
import com.mishustina.test_antal.entity.Document;
import com.mishustina.test_antal.entity.Test;
import com.mishustina.test_antal.repository.DictionaryRepository;
import com.mishustina.test_antal.repository.DocumentRepository;
import com.mishustina.test_antal.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;
    private final DocumentRepository documentRepository;
    private final DictionaryRepository dictionaryRepository;

    public TestServiceImpl(TestRepository testRepository,
                           DocumentRepository documentRepository,
                           DictionaryRepository dictionaryRepository) {
        this.testRepository = testRepository;
        this.dictionaryRepository = dictionaryRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public TestRecord getTestById(Long id) {
        Test test = testRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Not found test with id %s", id)));
        return TestConverter.convertTestToTestRecord(test);

    }

    @Override
    public Test createOrUpdateTest(TestRecord testRecord) {
        Document document = new Document();
        if (testRecord.getDocumentRecord() != null && testRecord.getDocumentRecord().getId() != null) {
            document = documentRepository.findById(testRecord.getDocumentRecord().getId())
                    .orElse(new Document());
        }
        Dictionary dictionary = new Dictionary();
        if (testRecord.getDictionaryRecord() != null && testRecord.getDictionaryRecord().getId() != null) {
            dictionary = dictionaryRepository.findById(testRecord.getDictionaryRecord().getId())
                    .orElse(new Dictionary());
        }

        Test test = new Test(document, dictionary);
        if (testRecord.getId() != null) {
            test = testRepository.findById(testRecord.getId())
                    .orElse(new Test(document, dictionary));
        }
        TestConverter.convertTestRecordToTest(testRecord, test);
        test.setDocument(TestConverter.convertDocumentRecordToDocument(testRecord.getDocumentRecord(), document));
        test.setDictionary(TestConverter.convertDictionaryRecordToDictionary(testRecord.getDictionaryRecord(), dictionary));
        return testRepository.save(test);
    }

    @Override
    public void deleteTestById(Long id) {
        testRepository.deleteById(id);
    }

}
