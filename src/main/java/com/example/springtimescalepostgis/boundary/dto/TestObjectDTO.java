package com.example.springtimescalepostgis.boundary.dto;

import com.example.springtimescalepostgis.domain.TestObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestObjectDTO {
    private int id;
    private double longitude;
    private double latitude;

    /**
     * This constructor is essential for the transformation between Point and latitude and longitude
     * @param object
     */
    public TestObjectDTO(TestObject object) {
        this.id = object.getId();
        this.latitude = object.getCoordinate().getX();
        this.longitude = object.getCoordinate().getY();
    }
}
