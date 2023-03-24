public class Detailed implements  WashMethod{
    public void wash (Vehicle vehicle){ //class for Detailed washing method /strat pattern
        if(vehicle.cleanliness == Enums.Cleanliness.Dirty){// if vehicle is dirty
            System.out.println(("The vehicle, "+ vehicle.name+ " is currently "+vehicle.cleanliness+ " with a condition of "+vehicle.condition+". It will now be washed using the Detailed Method."));
            if(Math.random() < 0.60){//60% chance vehicle will be clean
                vehicle.cleanliness = Enums.Cleanliness.Clean;
            }
            else if(Math.random() < 0.20){ //20% chance vehicle will become sparkling
                vehicle.cleanliness = Enums.Cleanliness.Sparkling;
            }
            else{ //no special effects
                System.out.println("No changes to vehicle made!");
            }
        }
        else{
            if(vehicle.cleanliness  == Enums.Cleanliness.Clean) { //same thing but this time with a clean vehicle
                System.out.println(("The vehicle, " + vehicle.name + " is currently " + vehicle.cleanliness + " with a condition of " + vehicle.condition + ". It will now be washed using the Detailed Method."));
                if (Math.random() < 0.05) {
                    vehicle.cleanliness = Enums.Cleanliness.Dirty;
                } else if (Math.random() < 0.40) {
                    vehicle.cleanliness = Enums.Cleanliness.Sparkling;
                }
                else{
                    System.out.println("No changes to vehicle made!");
                }
            }
        }//update statement to show how the vehicle changed
        System.out.println("The vehicle, "+ vehicle.name+ " now has cleanliness: " + vehicle.cleanliness+ " with a condition: " + vehicle.condition);
    }
}
