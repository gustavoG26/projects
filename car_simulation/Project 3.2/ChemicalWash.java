public class ChemicalWash implements WashMethod{//this is the class for the chemical wash method/strategy pattern
    public void wash(Vehicle vehicle){
        if(vehicle.cleanliness == Enums.Cleanliness.Dirty){ //if vehicle is dirty
            System.out.println(("The vehicle, "+ vehicle.name+ " is currently "+vehicle.cleanliness+ " with a condition of "+vehicle.condition+". It will now be washed using the Chemical Method."));
            if(Math.random() < 0.8){ //80%chance that dirty vehilce will become clean
                vehicle.cleanliness = Enums.Cleanliness.Clean;
            }
            else if(Math.random() < 0.1){ //10% chance it will become sparkling
                vehicle.cleanliness = Enums.Cleanliness.Sparkling;
            }
            else{ //10% chance of special effect broken occurring
                vehicle.condition = Enums.Condition.Broken;
            }
        }
        else{
            if(vehicle.cleanliness == Enums.Cleanliness.Clean) {// same thing but if vehicle is cleaned instead of broken
                System.out.println(("The vehicle, " + vehicle.name + " is currently " + vehicle.cleanliness + " with a condition of " + vehicle.condition + ". It will now be washed using the Chemical Method."));
                if (Math.random() < 0.1) {
                    vehicle.cleanliness = Enums.Cleanliness.Dirty;
                } else if (Math.random() < 0.2) {
                    vehicle.cleanliness = Enums.Cleanliness.Sparkling;
                } else if (Math.random() < 0.1) {
                    vehicle.condition = Enums.Condition.Broken;
                } else {
                    System.out.println("No changes to vehicle!");
                }
            }
        }//update statement to show how vehicle was updated, if there was any updates
        System.out.println("The vehicle, "+ vehicle.name+ " now has cleanliness: " + vehicle.cleanliness+ " with a condition: " + vehicle.condition);
    }
}
