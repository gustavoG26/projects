/*import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class StaffTest {

    @Test //test 1
    public void testIncrementRacesWon() {
        Staff staff = new Intern();
        staff.incrementRacesWon();
        assertEquals(1, staff.raceWon);
    }
    @Test//test2
    public void testSetQuit() {
        Staff staff = new Mechanic();
        staff.setQuit(true);
        assertTrue(staff.quit);
    }

    @Test//test3
    public void testShouldQuit() {
        Staff staff = new Intern();
        assertFalse(staff.shouldQuit());
    }

    @Test//test 4
    public void testGetStaffByType() {
        Intern intern1 = new Intern();
        Intern intern2 = new Intern();
        Mechanic mechanic = new Mechanic();
        ArrayList<Staff> staffList = new ArrayList<>(Arrays.asList(intern1, intern2, mechanic));

        ArrayList<Staff> interns = Staff.getStaffByType(staffList, Enums.StaffType.Intern);
        assertEquals(2, interns.size());
        assertTrue(interns.contains(intern1));
        assertTrue(interns.contains(intern2));

        ArrayList<Staff> mechanics = Staff.getStaffByType(staffList, Enums.StaffType.Mechanic);
        assertEquals(1, mechanics.size());
        assertTrue(mechanics.contains(mechanic));

        ArrayList<Staff> salespeople = Staff.getStaffByType(staffList, Enums.StaffType.Salesperson);
        assertEquals(0, salespeople.size());

        ArrayList<Staff> driver = Staff.getStaffByType(staffList, Enums.StaffType.Driver);
        assertEquals(0, driver.size());
    }

    @Test//test 5
    public void testHowManyStaffByType() {
        Intern intern1 = new Intern();
        Intern intern2 = new Intern();
        Mechanic mechanic = new Mechanic();
        ArrayList<Staff> staffList = new ArrayList<>(Arrays.asList(intern1, intern2, mechanic));

        assertEquals(2, Staff.howManyStaffByType(staffList, Enums.StaffType.Intern));
        assertEquals(1, Staff.howManyStaffByType(staffList, Enums.StaffType.Mechanic));
        assertEquals(0, Staff.howManyStaffByType(staffList, Enums.StaffType.Salesperson));
    }
    @Test//Test 6
    public void testIncrementRacesWonMultipleTimes() {
        Staff staff = new Intern();
        staff.incrementRacesWon();
        staff.incrementRacesWon();
        staff.incrementRacesWon();
        assertEquals(3, staff.raceWon);
    }

    @Test//test 7
    public void testSetQuitFalse() {
        Staff staff = new Mechanic();
        staff.setQuit(false);
        assertFalse(staff.quit);
    }
    //15 total JUnit Assertions
}
*/