package com.mishustina.test_antal.repository;

import com.mishustina.test_antal.SortOrder;
import com.mishustina.test_antal.entity.Dictionary;
import com.mishustina.test_antal.entity.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepositoryTest {
    @Autowired
    private TestRepository testRepository;

    @Test
    public void testSaveRepository(){
        Document document = new Document("Test document");
        Dictionary dictionary = new Dictionary("Test dictionary");
        com.mishustina.test_antal.entity.Test test = new com.mishustina.test_antal.entity.Test(document, dictionary);
        test.setName("Test test entity");
        test.setSortOrder(SortOrder.DESC);
        this.testRepository.save(test);
        assertNotNull(test.getId());
    }

    /*@Test
    public void testDeleteRepository(){
        com.mishustina.test_antal.dto.Test test = testRepository.findById(5L).get();
        testRepository.delete(test);
    }*/
}
