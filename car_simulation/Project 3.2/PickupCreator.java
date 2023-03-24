import java.util.List;
import java.util.Arrays;
public class PickupCreator implements VehicleCreator {//setting up factory pattern creation for pickups
    static List<String> names = Arrays.asList("Ranger","F-250","Chevy Colorado","Tundra");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        Pickup pickup = new Pickup();
        pickup.name = namer.getNext(); // set the pickups name
        return pickup;
    }
}