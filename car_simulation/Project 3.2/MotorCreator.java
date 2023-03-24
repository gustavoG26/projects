import java.util.List;
import java.util.Arrays;
public class MotorCreator implements VehicleCreator { //setting up factory pattern creation for motorcycles
    static List<String> names = Arrays.asList("Honda LS", "Harley","Yamaha", "Suzuki");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        Motor motor = new Motor();
        motor.name = namer.getNext(); // set the motor's name
        return motor;
    }
}