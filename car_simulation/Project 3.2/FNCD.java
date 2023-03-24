import javax.security.sasl.SaslException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


// This represents the FNCD business and things they would control
public class FNCD implements SysOut {
    ArrayList<Staff> staff;  // folks working
    ArrayList<Staff> departedStaff;   // folks that left
    static ArrayList<Vehicle> inventory;   // vehicles at the FNCD
    ArrayList<Vehicle> soldVehicles;   // vehicles the buyers bought
    private double budget;   // big money pile
    FNCD() {
        staff = new ArrayList<>();
        departedStaff = new ArrayList<>();
        inventory = new ArrayList<>();
        soldVehicles = new ArrayList<>();
        budget = 500000;  // I changed this just to see additions to the budget happen
    }
    double getBudget() {
        return budget;    // I'm keeping this private to be on the safe side
    }
    void moneyIn(double cash) {  // Nothing special about taking money in yet
        budget += cash;
    }
    void moneyOut(double cash) {   // I check for budget overruns on every payout
        budget -= cash;
        if (budget<0) {
            budget += 250000;
            out("***Budget overrun*** Added $250K, budget now: " + Utility.asDollar(budget));
        }
    }


    // Here's where I process daily activities
    // I debated about moving the individual activities out to an Activity class
    // It would make the normal day less of a monster maybe, eh...
    void updateStaffandInventory() {
        hireNewStaff();    // hire up to 3 of each staff type
        updateInventory();
    }

    void startWash() {
        ArrayList<Staff> interns = Staff.getStaffByType(staff, Enums.StaffType.Intern);
        for (Staff s:interns) {
            Intern i = (Intern) s;
            i.washVehicles(inventory);
        }
    }

    void startRepair() {
        ArrayList<Staff> mechanics = Staff.getStaffByType(staff, Enums.StaffType.Mechanic);
        for (Staff s:mechanics) {
            Mechanic m = (Mechanic) s;
            m.repairVehicles(inventory);
        }
    }

    void startSales(Enums.DayOfWeek day) {
        ArrayList<Buyer> buyers = getBuyers(day);
        ArrayList<Staff> salespeople = Staff.getStaffByType(staff, Enums.StaffType.Salesperson);
        // tell a random salesperson to sell each buyer a car - may get bonus
        for(Buyer b: buyers) {
            out("Buyer "+b.name+" wants a "+b.preference+" ("+b.type+")");
            int randomSeller = Utility.rndFromRange(0,salespeople.size()-1);
            Salesperson seller = (Salesperson) salespeople.get(randomSeller);
            Vehicle vSold = seller.sellVehicle(b, inventory);
            // What the FNCD needs to do if a car is sold - change budget and inventory
            if (vSold != null) {
                soldVehicles.add(vSold);
                moneyIn(vSold.price);
                inventory.removeIf ( n -> n.name == vSold.name);
            }
        }
    }

    void startRace() {
        race(inventory);
    }


    // generate buyers
    ArrayList<Buyer> getBuyers(Enums.DayOfWeek day) {
        // 0 to 5 buyers arrive (2-8 on Fri/Sat)
        int buyerMin = 0;  //normal Mon-Thur
        int buyerMax = 5;
        if (day == Enums.DayOfWeek.Fri || day == Enums.DayOfWeek.Sat) {
            buyerMin = 2;
            buyerMax = 8;
        }
        ArrayList<Buyer> buyers = new ArrayList<Buyer>();
        int buyerCount = Utility.rndFromRange(buyerMin,buyerMax);
        for (int i=1; i<=buyerCount; ++i) buyers.add(new Buyer());
        out("The FNCD has "+buyerCount+" buyers today...");
        return buyers;
    }


    // see if we need any new hires
    void hireNewStaff() {
        final int numberInStaff = 3;
        for (Enums.StaffType t : Enums.StaffType.values()) {
            int typeInList = Staff.howManyStaffByType(staff, t);
            int need = numberInStaff - typeInList;
            for (int i = 1; i<=need; ++i) addStaff(t);
        }
    }


    // adding staff
    // smells like we need a factory or something...
    void addStaff(Enums.StaffType t) {
        Staff newStaff = null;
        if (t == Enums.StaffType.Intern) newStaff = new Intern();
        if (t == Enums.StaffType.Mechanic) newStaff = new Mechanic();
        if (t == Enums.StaffType.Salesperson) newStaff = new Salesperson();
        if (t == Enums.StaffType.Driver) newStaff = new Driver();
        out("Hired a new "+newStaff.type+" named "+ newStaff.name);
        staff.add(newStaff);
    }


    // see if we need any vehicles
    void updateInventory() {
        final int numberInInventory = 6;
        for (Enums.VehicleType t : Enums.VehicleType.values()) {
            int typeInList = Vehicle.howManyVehiclesByType(inventory, t);
            int need = numberInInventory - typeInList;
            for (int i = 1; i<=need; ++i) addVehicle(t);
        }


    }


    // add a vehicle of a type to the inventory
    void addVehicle(Enums.VehicleType t) {
        Vehicle v = null;


        if (t == Enums.VehicleType.Car) {
            v = new Car();


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" for "+Utility.asDollar(v.cost));
        }
        if (t == Enums.VehicleType.PerfCar) {
            v = new PerfCar();


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" for "+Utility.asDollar(v.cost));
        }
        if (t == Enums.VehicleType.Pickup) {
            v = new Pickup();


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" for "+Utility.asDollar(v.cost));
        }
        if (t == Enums.VehicleType.OffRoad) {
            v = new Pickup();


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" for "+Utility.asDollar(v.cost));
        }
        if (t == Enums.VehicleType.SupCar) {
            v = new Pickup();


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" for "+Utility.asDollar(v.cost));
        }
        if (t == Enums.VehicleType.RV) {
            v = new Pickup();


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" for "+Utility.asDollar(v.cost));
        }
        if (t == Enums.VehicleType.Monster) {
            v = new Monster();


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" for "+Utility.asDollar(v.cost));
        }
        if (t == Enums.VehicleType.Motor) {
            v = new Motor();


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" with engine size of "+v.engineSize+" cubic centimeters for "+Utility.asDollar(v.cost));
        }
        if (t == Enums.VehicleType.ElecCar) {
            v = new ElecCar();


            if (v.condition == Enums.Condition.LikeNew) {
                v.carRange = v.carRange + 100;
            }


            out ("Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" with range "+v.carRange+" and range "+v.range+" for "+Utility.asDollar(v.cost));
        }


        inventory.add(v);
    }


    void race(ArrayList<Vehicle> vList) {
        // Create three empty ArrayLists to store the vehicles, drivers and race participants
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Vehicle> raceVehicles= new ArrayList<>();
        ArrayList<Staff> raceDriver = new ArrayList<>();

        // Get all the staff of type 'Driver' and store them in an ArrayList
        ArrayList<Staff> driver2 = Staff.getStaffByType(staff, Enums.StaffType.Driver);
        out("The Race is about to begin...");
        // Iterate through each vehicle in inventory
        for (Vehicle v : vList) {
            // Check if the vehicle's condition is not 'Broken', and it is not an electric or regular car
            if (v.condition != Enums.Condition.Broken && v.type != Enums.VehicleType.ElecCar && v.type != Enums.VehicleType.Car) {
                vehicles.add(v); //add vehicle if condition is satasfied
            }
        }
        // Shuffle the 'driver2' and 'vehicles' ArrayLists randomly
        Collections.shuffle(driver2);
        Collections.shuffle(vehicles);
        //print out all race participants
        out("Race participants:");
        // Get the minimum value between 3 and the size of the 'vehicles' inventory
        int numVehicles = Math.min(3, vehicles.size());

        // Iterate through the range of 0 to the value of 'numVehicles'
        for (int i = 0; i < numVehicles; i++){
            // Add the first 'numVehicles' vehicles and drivers to the 'raceVehicles' and 'raceDriver' ArrayLists respectively
            raceVehicles.add(vehicles.get(i));
            raceDriver.add(driver2.get(i));
            // Print a message indicating the vehicle and driver participating in the race
            out(String.format("Vehicle %s with driver %s", raceVehicles.get(i).name, raceDriver.get(i).name));
        }
        out("Drivers are racing...");
        out("The outcome is:");

        // Iterate through the range of 0 to the value of 'numVehicles'
        for (int i = 0; i < numVehicles; i++) {
            // Get the 'i'th vehicle and driver from the 'raceVehicles' and 'raceDriver' ArrayLists respectively
            Vehicle vehicle = raceVehicles.get(i);
            Staff driver = raceDriver.get(i);
            out(String.format("Vehicle %s with driver %s", vehicle.name, driver.name));
            int position = (int) (Math.random() * 20) + 1; // randomly determine race position
            if (position <= 3) { // winner
                out("Winner! the driver got a placement of "+position);
                vehicle.incrementRacesWon(); // increment races won count for vehicle
                driver.incrementRacesWon(); // increment races won count for driver
                if (vehicle.getRacesWon() >= 1) {
                    vehicle.price = vehicle.price * 1.1; // increase sale price by 10%
                    out(String.format("%s's sale price increased by 10%%", vehicle.name));
                }
                if (vehicle.getFNCD()) {
                    out(String.format("%s is a FNCD vehicle and its driver %s receives a cash bonus", vehicle.name, driver.name));
                    driver.bonusEarned += (vehicle.price * .15); // driver of FNCD vehicle receives cash bonus
                }
            } else if (position >= 16) { // damaged
                out("Car is Damaged! The driver got a placement of "+position);
                vehicle.condition = Enums.Condition.Broken; // set vehicle condition to broken
                if (vehicle.getFNCD()) {
                    int injuryChance = (int) (Math.random() * 3) + 1;
                    if (injuryChance <= 10) { // 30% chance of driver being injured
                        out(String.format("%s is a FNCD vehicle and its driver %s is injured", vehicle.name, driver.name));
                        driver.setQuit(true);
                    }
                }
            } else {
                out("The Driver did not win or get damaged but he got a placement of "+position);
            }
        }
    }

    // pay salary to staff and update days worked
    void payStaff() {
        for (Staff s: staff) {
            moneyOut(s.salary);  // money comes from the FNCD
            s.salaryEarned += s.salary;  // they get paid
            s.daysWorked += 1;// they worked another day
        }
    }

    void checkForQuitters() {
        //checking if any staff our quitters
        out("Checking for quitters...");
        //creating a list of staff members by type
        ArrayList<Staff> interns = Staff.getStaffByType(staff, Enums.StaffType.Intern);
        ArrayList<Staff> mechanics = Staff.getStaffByType(staff, Enums.StaffType.Mechanic);
        ArrayList<Staff> salesPeople = Staff.getStaffByType(staff, Enums.StaffType.Salesperson);
        if (Math.random() <= 0.1) {//random chance for quitting
            Collections.shuffle(interns);
            interns.get(0).setQuit(true);
            interns.remove(2);//remove if they are quitting
        }//check each staff type
        if (Math.random() <= 0.1) {
            Collections.shuffle(mechanics);
            mechanics.get(0).setQuit(true);
        }
        if (Math.random() <= 0.1) {
            Collections.shuffle(salesPeople);
            salesPeople.get(0).setQuit(true);
        }
        //store the original size of staff list.
        int ogSize = staff.size();
        //loop through each staff member
        for (int i = 0; i < staff.size(); i++) {
            Staff staffMember = staff.get(i);
            // Check if the staff member should quit
            if (staffMember.shouldQuit()) {
                // Create a variable to hold a random staff person
                Staff randomIntern = null;
                if (!interns.isEmpty()) {
                    randomIntern = interns.get(0);
                }
                // Check if the staff member is a driver
                if (staffMember.type == Enums.StaffType.Driver) {
                    // remove the driver from the staff list and add them to the departedStaff list
                    staff.remove(staffMember);
                    departedStaff.add(staffMember);
                    // Output a message indicating that the driver has left the staff
                    out(String.format("%s has left the staff to heal!", staffMember.name));
                } else if ((staffMember.type == Enums.StaffType.Mechanic) || (staffMember.type == Enums.StaffType.Salesperson)) {
                    // Remove the staff member from the staff list
                    staff.remove(staffMember);
                    // Create a new staff member to replace the one who quit
                    Staff newStaffMember;
                    if (staffMember.type == Enums.StaffType.Mechanic) {
                        // If the staff member being replaced is a Mechanic, a new Mechanic object is created
                        newStaffMember = new Mechanic();
                        newStaffMember.name = randomIntern.name;
                        newStaffMember.daysWorked = randomIntern.daysWorked;
                        newStaffMember.bonusEarned = randomIntern.bonusEarned;
                        newStaffMember.salaryEarned = randomIntern.salaryEarned;
                    } else {
                        // Otherwise, a new Salesperson object is created
                        // The attributes of the new staff member are then set to the attributes
                        // of the intern who will be replacing them,
                        newStaffMember = new Salesperson();
                        newStaffMember.name = randomIntern.name;
                        newStaffMember.daysWorked = randomIntern.daysWorked;
                        newStaffMember.bonusEarned = randomIntern.bonusEarned;
                        newStaffMember.salaryEarned = randomIntern.salaryEarned;
                    }
                    staff.add(newStaffMember);
                    staff.remove(randomIntern);
                    departedStaff.add(staffMember);
                    interns.remove(0);
                   /*out(randomIntern.name+", "+randomIntern.daysWorked+", "+randomIntern.bonusEarned+", "+randomIntern.salaryEarned+", "+randomIntern.salary+", "+randomIntern.quit);
                   out(newStaffMember.name+", "+newStaffMember.daysWorked+", "+newStaffMember.bonusEarned+", "+newStaffMember.salaryEarned+", "+newStaffMember.salary+", "+newStaffMember.quit);*/
                    out(String.format("%s has quit from the staff with position of %s and intern %s has taken their spot!", staffMember.name, staffMember.type, newStaffMember.name));
                } else {
                    // remove the staff member from the staff list and add them to the departedStaff list
                    staff.remove(staffMember);
                    departedStaff.add(staffMember);
                    out(String.format("%s has quit from the staff with position of %s", staffMember.name, staffMember.type));
                }
            }
        }
        if (ogSize == staff.size()) {
            out("No one wanted to quit today!");
        }
    }

    void reportOut() {
        // We're all good here, how are you?
        // Quick little summary of happenings, you could do better
        out("Vehicles in inventory "+inventory.size());
        out("Vehicles sold count "+soldVehicles.size());
        out("Staff that still work there "+staff.size());
        out("Staff that have departed "+departedStaff.size());
        out("Money in the budget "+ Utility.asDollar(getBudget()));
        out("That's it for the day.");
    }


}
