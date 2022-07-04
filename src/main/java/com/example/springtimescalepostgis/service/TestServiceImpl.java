package com.example.springtimescalepostgis.service;

import com.example.springtimescalepostgis.boundary.dto.TestObjectDTO;
import com.example.springtimescalepostgis.domain.TestObject;
import com.example.springtimescalepostgis.repository.TestObjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TestServiceImpl implements TestService{

    private final TestObjectRepository testObjectRepository;

    private static final GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

    public TestServiceImpl(TestObjectRepository testObjectRepository) {
        this.testObjectRepository = testObjectRepository;
    }

    @Override
    public void addObject(TestObjectDTO dto) {
        Point p = factory.createPoint(new Coordinate(dto.getLatitude(),dto.getLongitude()));
        testObjectRepository.save(new TestObject(dto.getId(), p));
    }

    @Override
    public List<TestObject> getAllObjects() {
        return testObjectRepository.findAll();
    }
}
