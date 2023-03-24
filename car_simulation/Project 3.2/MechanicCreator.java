import java.util.List;
import java.util.Arrays;
public class MechanicCreator implements StaffCreator {//setting up factory pattern creation for mechanics
    static List<String> names = Arrays.asList("James", "Scotty", "Spock", "Uhura");
    private static Namer namer = new Namer(names);

    @Override
    public Staff createStaff() {
        Mechanic mechanic = new Mechanic();
        mechanic.name = namer.getNext(); // set the mechanic's name
        return mechanic;
    }
}