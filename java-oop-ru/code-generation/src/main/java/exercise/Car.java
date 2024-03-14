package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@AllArgsConstructor
@Getter
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public Car() {
    }

    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        String carToJson = "";
        try {
            carToJson = mapper.writeValueAsString(this);
        }
        catch (Exception e) {
            System.out.println("Can not create JSON from this object");
        }
        return carToJson;
    }

    public static Car unserialize(String carToString) {
        ObjectMapper mapper = new ObjectMapper();
        Car jsonToCar = new Car();
        try {
            jsonToCar = mapper.readValue(carToString, Car.class);
        }
        catch (Exception e) {
            System.out.println("Can not create Car from this string");
        }
        return jsonToCar;
    }
    // END
}
