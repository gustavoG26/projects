import java.util.List;
import java.util.Arrays;
public class RVCreator implements VehicleCreator {//setting up factory pattern creation for super cars
    static List<String> names = Arrays.asList("American Coach", "Coachmen RV", "Forest River RV", "Jayco", "Newmar");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        RV rv = new RV();
        rv.name = namer.getNext(); // set the pickups name
        return rv;
    }
}