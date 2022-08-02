package com.mishustina.test_antal.service;

import com.mishustina.test_antal.dto.TestRecord;
import com.mishustina.test_antal.entity.Test;

public interface TestService {

    TestRecord getTestById(Long id);

    Test createOrUpdateTest(TestRecord testRecord);

    void deleteTestById(Long id);
}
