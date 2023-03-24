/*
The Buyer class has an ArrayList of Staff objects as an instance variable, which suggests that it is intended to interact with the Staff class in some way.
The Buyer class has a constructor that sets the name, type, and preference instance variables. The preference variable is randomly set to a value from the Enums.VehicleType enumeration, and the type variable is randomly set to a value from the Enums.BuyerType enumeration. The name variable is set using a Namer object that generates names from a list of predefined names.
The humanInterface() method is a method that prints out a series of options for the buyer to select from, and then prompts the buyer to enter a command. Depending on the command entered, the method prints out different information, such as the name of the salesperson, the current time, the current inventory, or details about a specific inventory item.
The humanInterface() method uses a Scanner object to get input from the user. It uses a switch statement to handle different cases based on the command entered by the user.
The humanInterface() method contains a for loop that runs indefinitely until the buyer selects the "Exit" option.
Overall, the Buyer class appears to be intended to simulate a buyer interacting with a dealership,
by providing a series of options for the buyer to select from and then displaying information based on the selected option.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


// Quick little buyer class that can take care of its name and initialization
public class Buyer {

    ArrayList<Staff> staff;

    String name;
    Enums.BuyerType type;
    Enums.VehicleType preference;
    static List<String> names = Arrays.asList("Luke","Leia","Han","Chewy");
    static Namer namer = new Namer(names);
    Buyer() {

        // even chances for these randoms - could weight them if needed
        preference = Utility.randomEnum(Enums.VehicleType.class);
        type = Utility.randomEnum(Enums.BuyerType.class);
        name = namer.getNext();

    }

    void humanInterface() {
        Scanner customerSelect = new Scanner(System.in);
        System.out.println("Hello Customer, you are entering the FNCD interface \n");
        while (true) {
            System.out.println("1. Ask the salesperson their name");
            System.out.println("2. Ask the salesperson what time it is");
            System.out.println("3. Ask for a different salesperson");
            System.out.println("4. Ask the salesperson for current store inventory");
            System.out.println("5. Ask the salesperson for all details on a user selected inventory item");
            System.out.println("6. Buy a normal inventory item from the salesperson");
            System.out.println("7. Exit");

            int command = customerSelect.nextInt();
            switch (command) {
                case 1:
                    Enums.StaffType a;
                    a = Enums.StaffType.Salesperson;
                    Staff newStaff = new Salesperson();
                    System.out.println("Your salesperson name is " + newStaff.name + "\n");
                    break;
                case 2:
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss a");
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println("Hello customer, the current time is " + dtf.format(now) + "\n");
                    break;
                case 3:
                    Enums.StaffType b;
                    b = Enums.StaffType.Salesperson;
                    Staff changeStaff = new Salesperson();
                    System.out.println("Your new salesperson name is " + changeStaff.name + "\n");
                    break;
                case 4:
                    System.out.println("The inventory is the following: \n");
                    for (Vehicle vehicle : FNCD.inventory) {
                        System.out.println(vehicle.name);
                    }
                    break;
                case 5:
                    int i = 1;
                    for (Vehicle vehicle : FNCD.inventory) {
                        System.out.println(i + ". " + vehicle.name);
                        i++;
                    }
                    System.out.println("Input the corresponding number of the list to show the details from the vehicle:");
                    Scanner vehicleSelect = new Scanner(System.in);
                    int selectedVehicleIndex = vehicleSelect.nextInt() - 1;
                    if (selectedVehicleIndex < 0 || selectedVehicleIndex >= FNCD.inventory.size()) {
                        System.out.println("Invalid selection.");
                    } else {
                        Vehicle selectedVehicle = FNCD.inventory.get(selectedVehicleIndex);
                        System.out.println("Details for " + selectedVehicle.name + ":");
                        System.out.println("Price: $" + selectedVehicle.price);
                        System.out.println("Cleanliness: " + selectedVehicle.cleanliness);
                        System.out.println("Type: " + selectedVehicle.type);
                        System.out.println("Condition: " + selectedVehicle.condition);
                    }
                    break;
                case 6:
                    int j = 1;
                    for (Vehicle vehicle : FNCD.inventory) {
                        System.out.println(j + ". " + vehicle.name);
                        j++;
                    }
                    System.out.println("Input the corresponding number of the list to buy the vehicle:");
                    Scanner buySelect = new Scanner(System.in);
                    int selectedBuyIndex = buySelect.nextInt() - 1;
                    if (selectedBuyIndex < 0 || selectedBuyIndex >= FNCD.inventory.size()) {
                        System.out.println("Invalid selection.");
                    } else {
                        Vehicle selectedVehicle = FNCD.inventory.get(selectedBuyIndex);
                        System.out.println("You have bought " + selectedVehicle.name + " for $" + selectedVehicle.price);
                        FNCD.inventory.remove(selectedBuyIndex);
                    }
                    break;
                case 7:
                    System.out.println("Thank you for using FNCD. Goodbye!");
                    System.exit(0);
                default:
                    break;
            }
        }
    }


}

