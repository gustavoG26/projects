import java.util.List;
import java.util.Arrays;
public class OffRoadCreator implements VehicleCreator {//setting up factory pattern creation for offraod
    static List<String> names = Arrays.asList("Ford Bronco", "Jeep Wrangler", "Land Rover Defender", "Mercedes-Benz G-Class", "Toyota Tacoma TRD Pro");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        OffRoad offRoad = new OffRoad();
        offRoad.name = namer.getNext(); // set the pickups name
        return offRoad;
    }
}