package com.example.springtimescalepostgis.repository;

import com.example.springtimescalepostgis.domain.TestObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestObjectRepository extends JpaRepository<TestObject, Integer> {
}
