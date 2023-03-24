import java.util.ArrayList;
import java.util.List;

public class SimulationPublisher implements Observable {
    private List<Observer> observers = new ArrayList<>(); //eager instantiation
    //static final means this value cannot be changed once initialized
    //For singleton, this means this instance will only be created once
    private static final SimulationPublisher instance = new SimulationPublisher();

    public SimulationPublisher() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(SimulationEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void addMoneyToBudget(double amount, String description) {
        SimulationEvent event = new SimulationEvent("Adding money to budget", amount, description);
        notifyObservers(event);
    }

    public void addOutcome(String eventType, double amount, String description) {
        SimulationEvent event = new SimulationEvent(eventType, amount, description);
        notifyObservers(event);
    }
    /*
    The eager instantiation of the class is here in the getInstance() method.
    we initialize the instance immediately in our private constructor, so when
    we call the public getInstance() method, it simply returns the instance.
    This makes it to where we do not have to worry about any concurrency issues.
    Note this is different from the Logger lazy instantiation, since we used
    'synchronized' and also setting creating a new instance, whereas here, we do
    not have to do all that extra effort.
    */
    public static  SimulationPublisher getInstance(){
        return instance;
    }


}
