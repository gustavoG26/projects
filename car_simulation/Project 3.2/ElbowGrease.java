public class ElbowGrease implements WashMethod {// this is a class for the elbow grease method/strat pattern
    public void wash(Vehicle vehicle){
        if(vehicle.cleanliness == Enums.Cleanliness.Dirty){// if vehicle is dirty
            System.out.println(("The vehicle, "+ vehicle.name+ " is currently "+vehicle.cleanliness+ " with a condition of "+vehicle.condition+". It will now be washed using the Elbow Grease Method."));
            if(Math.random() < 0.7){ //70% chance vehicle will become clean
                vehicle.cleanliness = Enums.Cleanliness.Clean;
            }
            else if(Math.random() < 0.05){//5% chance it will become sparkling
                vehicle.cleanliness = Enums.Cleanliness.Sparkling;
            }
            else if(Math.random() < 0.1){//10% chance of special effect happening
                vehicle.condition = Enums.Condition.LikeNew;
            }
            else{ //nothing happens
                System.out.println("No changes to vehicle!");
            }
        }
        else{
            if(vehicle.cleanliness == Enums.Cleanliness.Clean) { //same things, different percentages for clean vehicles
                System.out.println(("The vehicle, " + vehicle.name + " is currently " + vehicle.cleanliness + " with a condition of " + vehicle.condition + ". It will now be washed using the Elbow Grease Method."));
                if (Math.random() < 0.15) {
                    vehicle.cleanliness = Enums.Cleanliness.Dirty;
                } else if (Math.random() < 0.15) {
                    vehicle.cleanliness = Enums.Cleanliness.Sparkling;
                } else if (Math.random() < 0.10) {
                    vehicle.condition = Enums.Condition.LikeNew;
                }
                else{
                    System.out.println("No changes to vehicle!");
                }
            }
        }//update message to show what changes the vehicle has undergone, if there are any
        System.out.println("The vehicle, "+ vehicle.name+ " now has cleanliness: " + vehicle.cleanliness+ " with a condition: " + vehicle.condition);
    }
}
