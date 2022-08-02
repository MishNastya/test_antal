package com.mishustina.test_antal.repository;

import com.mishustina.test_antal.entity.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
}
