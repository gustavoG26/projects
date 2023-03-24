import java.util.List;
import java.util.Arrays;
public class SalesPersonCreator implements StaffCreator {//setting up factory pattern creation for salesperson
    static List<String> names = Arrays.asList("Jokic","Thorfinn","Phoebe","Chandler","Ross","Joey");
    private static Namer namer = new Namer(names);

    @Override
    public Staff createStaff() {
        Salesperson salesperson = new Salesperson();
        salesperson.name = namer.getNext(); // set the salesperson's name
        return salesperson;
    }
}