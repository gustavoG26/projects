public class SimulationEvent { //observer pattern first touches
    private String eventType;
    private double amount;
    private String description;
    public SimulationEvent(String eventType, double amount, String description){
        this.eventType = eventType;
        this.amount = amount;
        this.description = description;
    }
    public String getEventType(){
        return eventType;
    }
    public double getAmount(){
        return amount;
    }
    public String getDescription(){
        return description;
    }
}
