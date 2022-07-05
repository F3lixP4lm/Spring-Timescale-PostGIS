# Spring-Timescale-PostGIS
Repository which demonstrates the integration of Timescale and PostGIS in a Spring Boot application. 

Implementation also works with standard PostGIS Docker Image, replace f.e. `postgis/postgis:14-3.2-alpine` in the docker-compose file. 

## Connection 

The database connection is configured within the [application.yml](https://github.com/F3lixP4lm/Spring-Timescale-PostGIS/blob/99e2856dc70b2705700d1e63a8994b72c5f72e09/src/main/resources/application.yml)

After starting the container and successfully configuring the database, the Spring application connects to the database immediately after startup.

## SwaggerUI 
With the help of Swagger, which is available after launching the Spring application, the application can be tested. 

Link: 
http://localhost:8080/swagger-ui/index.html

## Configuration

Between [TestObjectDTO](https://github.com/F3lixP4lm/Spring-Timescale-PostGIS/blob/99e2856dc70b2705700d1e63a8994b72c5f72e09/src/main/java/com/example/springtimescalepostgis/boundary/dto/TestObjectDTO.java) and 
[TestObject](https://github.com/F3lixP4lm/Spring-Timescale-PostGIS/blob/99e2856dc70b2705700d1e63a8994b72c5f72e09/src/main/java/com/example/springtimescalepostgis/domain/TestObject.java) the transformation of the coordinates differs.

The coordinates entered as latitude/longitude are transformed within the service into a point that can be stored by PostGIS. 

```
private static final GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);
[...]
 @Override
    public void addObject(TestObjectDTO dto) {
        Point p = factory.createPoint(new Coordinate(dto.getLatitude(),dto.getLongitude()));
        testObjectRepository.save(new TestObject(dto.getId(), p));
    }
```

When the object is queried, this Point variable is converted back to latitude/longitude format within the constructor of the TestObjectDTO. 

```java
public TestObjectDTO(TestObject object) {
        this.id = object.getId();
        this.latitude = object.getCoordinate().getX();
        this.longitude = object.getCoordinate().getY();
    }
```
