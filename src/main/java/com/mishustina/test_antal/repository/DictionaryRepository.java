package com.mishustina.test_antal.repository;

import com.mishustina.test_antal.entity.Dictionary;
import org.springframework.data.repository.CrudRepository;

public interface DictionaryRepository extends CrudRepository<Dictionary, Long> {
}
