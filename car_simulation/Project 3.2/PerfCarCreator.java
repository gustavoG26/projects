import java.util.List;
import java.util.Arrays;
public class PerfCarCreator implements VehicleCreator {//setting up factory pattern creation for perfcars
    static List<String> names = Arrays.asList("Europa","Cayman","Corvette","Mustang GT");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        PerfCar perfCar = new PerfCar();
        perfCar.name = namer.getNext(); // set the intern's name
        return perfCar;
    }
}