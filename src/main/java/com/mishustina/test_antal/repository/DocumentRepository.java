package com.mishustina.test_antal.repository;

import com.mishustina.test_antal.entity.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
