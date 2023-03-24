import java.util.List;
import java.util.Arrays;
public class CarCreator implements VehicleCreator {//setting up factory pattern creation for cars
    static List<String> names = Arrays.asList("ProbeXS","Escort","Taurus","Fiesta");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        Car car = new Car();
        car.name = namer.getNext(); // set the car's name
        return car;
    }
}