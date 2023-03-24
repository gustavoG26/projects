public class Tracker implements Observer { //observer patterns
    private double totalStaffMoneyEarned;
    private double totalFncdMoneyEarned;
    private static final Tracker instance = new Tracker(); //eager instantation

    public Tracker() {
        totalStaffMoneyEarned = 0.0;
        totalFncdMoneyEarned = 0.0;
    }

    @Override
    public void update(SimulationEvent event) {
        String eventType = event.getEventType();
        double amount = event.getAmount();
    }
    public void printSummary(int day) {
        System.out.println("Tracker: Day " + day);
        System.out.println("Total money earned by all Staff: $" + totalStaffMoneyEarned);
        System.out.println("Total money earned by the FNCD: $" + totalFncdMoneyEarned);
    }
    public static void main(String[] args) {
        // create the Logger and Tracker subscribers
        Logger logger = new Logger();
        Tracker tracker = new Tracker();

        // create the event publisher and register the subscribers
        SimulationPublisher simulationPublisher = new SimulationPublisher();
        simulationPublisher.addObserver(logger);
        simulationPublisher.addObserver(tracker);

        // simulate 5 days of events
        for (int day = 1; day <= 5; day++) {
            tracker.printSummary(day);
        }
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
    public static  Tracker getInstance(){
        return instance;
    }

}
