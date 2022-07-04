package com.example.springtimescalepostgis.service;

import com.example.springtimescalepostgis.boundary.dto.TestObjectDTO;
import com.example.springtimescalepostgis.domain.TestObject;

import java.util.List;

public interface TestService {

    void addObject(TestObjectDTO dto);
    List<TestObject> getAllObjects();
}
