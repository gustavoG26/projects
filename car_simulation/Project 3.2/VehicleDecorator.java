//decorator class
public abstract class VehicleDecorator implements VehicleDec {
    public Vehicle decoratedVehicle;
    public VehicleDecorator(Vehicle decoratedVehicle){
        this.decoratedVehicle = decoratedVehicle;
    }
    public double getPrice(){
        return decoratedVehicle.price;
    }

}
//Concrete Decorator
class ExtendedWarranty extends VehicleDecorator{
    public ExtendedWarranty(Vehicle decoratedVehicle){
        super(decoratedVehicle);
    }

    public double getPrice(){
        return decoratedVehicle.price * 1.2; //20% price increase to vehicle
    }
}

//Concrete Decorator
class Undercoating extends VehicleDecorator{
    public Undercoating(Vehicle decoratedVehicle){
        super(decoratedVehicle);
    }
    public double getPrice(){
        return decoratedVehicle.price * 1.05; //5% price increase to vehicle
    }

}
//Concrete decorator
class RoadRescue extends VehicleDecorator{
    public RoadRescue(Vehicle decoratedVehicle){
        super(decoratedVehicle);
    }
    public double getPrice(){
        return decoratedVehicle.price * 1.02; //2% price increase to vehicle
    }
}
//Last concrete decorator
class Satellite extends VehicleDecorator{
    public Satellite(Vehicle decoratedVehicle){
        super(decoratedVehicle);
    }

    public double getPrice(){
        return decoratedVehicle.price * 1.05; //5% price increase to vehicle
    }

}



