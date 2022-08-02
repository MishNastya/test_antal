package com.mishustina.test_antal.controller;

import com.mishustina.test_antal.dto.TestRecord;
import com.mishustina.test_antal.service.TestService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public TestRecord getTest(Long id) {
        return testService.getTestById(id);
    }

    @PostMapping("/")
    public void createTest(TestRecord testRecord) {
        if (testRecord.getId() != null) {
            throw new IllegalArgumentException("Cannot create object with filled ID");
        }
        testService.createOrUpdateTest(testRecord);
    }

    @PutMapping("/")
    public void updateTest(TestRecord testRecord) {
        if (testRecord.getId() == null) {
            throw new IllegalArgumentException("Cannot update object with not filled ID");
        }
        testService.createOrUpdateTest(testRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable Long id) {
        testService.deleteTestById(id);
    }

}
