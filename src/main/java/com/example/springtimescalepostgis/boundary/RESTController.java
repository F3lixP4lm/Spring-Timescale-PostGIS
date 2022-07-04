package com.example.springtimescalepostgis.boundary;

import com.example.springtimescalepostgis.boundary.dto.TestObjectDTO;
import com.example.springtimescalepostgis.service.TestServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RESTController {

    private final TestServiceImpl testService;

    public RESTController(TestServiceImpl testService) {
        this.testService = testService;
    }


    @PostMapping("/test")
    public void addTestObject(TestObjectDTO dto){
        testService.addObject(dto);
    }

    @GetMapping("/test")
    public ResponseEntity<List<TestObjectDTO>> findAllObjects(){
        List<TestObjectDTO> response = new ArrayList<>();
        testService.getAllObjects().forEach(object -> response.add(new TestObjectDTO(object)));
        return ResponseEntity.ok(response);
    }
}
