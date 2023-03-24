import java.util.List;
import java.util.Arrays;
public class DriverCreator implements StaffCreator {//setting up factory pattern creation for drivers
    static List<String> names  = Arrays.asList("Arthur Morgan", "John", "Michael", "Joe");
    private static Namer namer = new Namer(names);

    @Override
    public Staff createStaff() {
        Driver driver = new Driver();
        driver.name = namer.getNext(); // set the driver's name
        return driver;
    }
}