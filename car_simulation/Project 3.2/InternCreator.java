import java.util.List;
import java.util.Arrays;
public class InternCreator implements StaffCreator {//setting up factory pattern creation for interns
    private static List<String> names = Arrays.asList("Fred","Ethel","Lucy","Desi");
    private static Namer namer = new Namer(names);

    @Override
    public Staff createStaff() {
        Intern intern = new Intern();
        intern.name = namer.getNext(); // set the intern's name
        return intern;
    }
}