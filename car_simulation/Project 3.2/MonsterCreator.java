import java.util.List;
import java.util.Arrays;
public class MonsterCreator implements VehicleCreator {//setting up factory pattern creation for Monster Trucks
    static List<String> names = Arrays.asList("Air Force Afterburnerz", "Avenger", "Batman", "Backwards Bob", "Bear Foot(1979)", "Bear Foot (F-150)", "Bear Foot (2xtreme)", "Bear Foot (Silverado)", "Bear Foot USA", "Bigfoot", "Black Stallion", "Blacksmith", "Blue Thunder", "Bounty Hunter", "Brutus", "Bulldozer", "Captain's Curse", "Cyborg", "El Toro Loco", "Grave Digger");
    private static Namer namer = new Namer(names);

    @Override
    public Vehicle createVehicle() {
        Monster monster = new Monster();
        monster.name = namer.getNext(); // set the truck's name
        return monster;
    }
}