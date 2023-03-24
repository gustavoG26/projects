import java.util.List;
import java.util.Arrays;
public class SupCarCreator implements VehicleCreator {//setting up factory pattern creation for super cars
    static List<String> names = Arrays.asList("McLaren F1", "Bugatti Veyron Super Sport", "Ferrari LaFerrari", "McLaren P1", "Porsche 918 Spyder");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        SuperCar superCar = new SuperCar();
        superCar.name = namer.getNext(); // set the pickups name
        return superCar;
    }
}