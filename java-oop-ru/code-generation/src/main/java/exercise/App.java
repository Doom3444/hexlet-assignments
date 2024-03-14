package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {

    public static void save(Path path, Car car) {
        String carToJson = car.serialize();
        try {
            Files.writeString(path, carToJson);
        }
        catch (Exception e) {
            System.out.println("Can not write to file");
        }
    }

    public static Car extract(Path path) {
        String jsonToCar = new String();
        try {
            jsonToCar = Files.readString(path);
        }
        catch (Exception e) {
            System.out.println("Can not read the file");
        }
        return Car.unserialize(jsonToCar);
    }
}
// END
