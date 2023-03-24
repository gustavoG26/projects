import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Vehicle {
    String name;
    Enums.VehicleType type;
    Enums.Condition condition;
    Enums.Cleanliness cleanliness;
    double cost;
    double price;
    double repair_bonus;
    double wash_bonus;
    double sale_bonus;
    double range;
    double carRange;
    double engineSize;
    int raceWon;

    Vehicle () {
        // all vehicles have the same cleanliness arrival chance
        double chance = Utility.rnd();
        if (chance <= .05) cleanliness = Enums.Cleanliness.Sparkling;
        else if (chance>.05 && chance<=.4) cleanliness = Enums.Cleanliness.Clean;
        else cleanliness = Enums.Cleanliness.Dirty;
        // all vehicles have the same condition arrival chance (even chance of any)
        condition = Utility.randomEnum(Enums.Condition.class);
    }
    int getRacesWon() {
        return raceWon;
    }
    void incrementRacesWon() {
        raceWon++;
    }
    boolean getFNCD() {
        return (this.type == Enums.VehicleType.Motor) || (this.type == Enums.VehicleType.Monster) || (this.type == Enums.VehicleType.PerfCar) || (this.type == Enums.VehicleType.Pickup);
    }
    double getRange(int low, int high) {
        double range = Utility.rndFromRange(low, high);
        return range;
    }


    // utility for getting adjusted cost by condition
    double getCost(int low,int high) {
        double cost = Utility.rndFromRange(low, high);
        if (condition== Enums.Condition.Used) cost = cost*.8;
        if (condition== Enums.Condition.Broken) cost = cost*.5;
        return cost;
    }

    // utility for getting Vehicles by Type
    // You could do this with getClass instead of Type, but I use the enum
    // because it's clearer to me (less Java-y)
    static ArrayList<Vehicle> getVehiclesByType(ArrayList<Vehicle> vehicleList, Enums.VehicleType t) {
        ArrayList<Vehicle> subclassInstances = new ArrayList<>();
        for (Vehicle v : vehicleList) {
            if (v.type == t) subclassInstances.add(v);
        }
        return subclassInstances;
    }

    // Utility for finding out how many of a Vehicle there are
    static int howManyVehiclesByType(ArrayList<Vehicle> vehicleList, Enums.VehicleType t) {
        int n = 0;
        for (Vehicle v: vehicleList) {
            if (v.type == t) n++;
        }
        return n;
    }
}

class Car extends Vehicle {
    // could make the name list longer to avoid as many duplicates if you like...
    static List<String> names = Arrays.asList("Probe","Escort","Taurus","Fiesta");
    static Namer namer = new Namer(names);
    Car() {
        super();
        type = Enums.VehicleType.Car;
        name = namer.getNext();  // every new car gets a new name
        cost = getCost(10000,20000);
        price = cost * 2;
        repair_bonus = 100;
        wash_bonus = 20;
        sale_bonus = 500;
    }
}

class PerfCar extends Vehicle {
    static List<String> names = Arrays.asList("Europa","Cayman","Corvette","Mustang");
    static Namer namer = new Namer(names);
    PerfCar() {
        super();
        type = Enums.VehicleType.PerfCar;
        name = namer.getNext();  // every new perf car gets a unique new name
        cost = getCost(20000,40000);
        price = cost * 2;
        repair_bonus = 300;
        wash_bonus = 100;
        sale_bonus = 1000;
    }
}

class Pickup extends Vehicle {
    static List<String> names = Arrays.asList("Ranger","F-250","Colorado","Tundra");
    static Namer namer = new Namer(names);
    Pickup() {
        super();
        type = Enums.VehicleType.Pickup;
        name = namer.getNext();  // every new truck gets a unique new name
        cost = getCost(10000,40000);
        price = cost * 2;
        repair_bonus = 200;
        wash_bonus = 75;
        sale_bonus = 750;
    }
}
class ElecCar extends Vehicle {
    static List<String> names = Arrays.asList("Tesla", "BMW-IX", "Kia-EV6", "Cadillac-LYRIQ");
    static Namer namer = new Namer(names);
    ElecCar() {
        super();
        type = Enums.VehicleType.ElecCar;
        name = namer.getNext();
        cost = getCost(1500, 40000);
        range = getRange(60, 400);
        price = cost * 2;
        carRange = range;
        repair_bonus = 150;
        wash_bonus = 60;
        sale_bonus = 600;
    }
}


class Monster extends Vehicle {
    static List<String> names = Arrays.asList("Air Force Afterburner", "Avenger", "Batman", "Backwards Bob", "Bear Foot(1979)", "Bear Foot (F-150)", "Bear Foot (2xtreme)", "Bear Foot (Silverado)", "Bear Foot USA", "Bigfoot", "Black Stallion", "Blacksmith", "Blue Thunder", "Bounty Hunter", "Brutus", "Bulldozer", "Captain's Curse", "Cyborg", "El Toro Loco", "Grave Digger");
    static Namer namer = new Namer(names);
    Monster() {
        super();
        type = Enums.VehicleType.Monster;
        name = namer.getNext();  // every new truck gets a unique new name
        cost = getCost(30000,55000);
        price = cost * 2;
        repair_bonus = 400;
        wash_bonus = 150;
        sale_bonus = 1250;
    }
}


class Motor extends Vehicle {
    static List<String> names = Arrays.asList("Honda", "Harley","Yamaha", "Suzuki");
    static Namer namer = new Namer(names);
    private static final Random random = new Random();
    private static final double MEAN_CC = 700;
    private static final double STD_DEV_CC = 300;
    private static final double MIN_CC = 50;


    Motor() {
        super();
        type = Enums.VehicleType.Motor;
        name = namer.getNext();  // every new truck gets a unique new name
        cost = getCost(12500,45000);
        price = cost * 2;
        repair_bonus = 500;
        wash_bonus = 100;
        sale_bonus = 1000;


        do {
            engineSize = random.nextGaussian() * STD_DEV_CC + MEAN_CC;
        } while (engineSize < MIN_CC);
    }


}

class OffRoad extends Vehicle {
    OffRoad() {
        super();
        type = Enums.VehicleType.OffRoad;
        cost = getCost(15000,45000);
        price = cost * 2;
        repair_bonus = 450;
        wash_bonus = 175;
        sale_bonus = 1375;
    }
}

class SuperCar extends Vehicle {
    SuperCar() {
        super();
        type = Enums.VehicleType.SupCar;
        cost = getCost(100000,150000);
        price = cost * 2;
        repair_bonus = 600;
        wash_bonus = 250;
        sale_bonus = 4000;
    }
}

class RV extends Vehicle {
    RV() {
        super();
        type = Enums.VehicleType.RV;
        cost = getCost(25000,60000);
        price = cost * 2;
        repair_bonus = 500;
        wash_bonus = 300;
        sale_bonus = 1750;
    }
}



