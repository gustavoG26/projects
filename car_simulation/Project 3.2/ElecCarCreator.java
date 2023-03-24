import java.util.List;
import java.util.Arrays;
public class ElecCarCreator implements VehicleCreator {//setting up factory pattern creation for eleccars
    static List<String> names = Arrays.asList("Tesla X", "BMW-IX", "Kia-EV6", "Cadillac-LYRIQ");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        ElecCar elecCar = new ElecCar();
        elecCar.name = namer.getNext(); // set the elecar's name
        return elecCar;
    }
}