import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements Observer {//observer patter
    private static int dayCount = 0;
    private FileWriter writer;
    private static Logger instance; //defining logger object instance for getInstance()

    public Logger() {
        dayCount++;
        try {
            writer = new FileWriter("Logger-" + dayCount + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(SimulationEvent event) {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logMessage = formattedDate + " - " + event.getEventType() + ": " + event.getDescription() + " ($" + event.getAmount() + ")\n";
        try {
            writer.write(logMessage);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //we use synchronized to prevent thread interface and also concurrency problems
    //https://www.mygreatlearning.com/blog/synchronization-in-java/#:~:text=Synchronization%20in%20java%20is%20the,for%20reliable%20communication%20between%20threads.
    /*
    The lazy instantiation of this class is the getInstance() method
    Here we are creating an object that is 'delayed/not used' until
    it is actually needed. So first we are checking if our instance
    variable is null, if it is, no instance of Logger has been created
    so we simply create a new one, which is essentially lazy instantiation.
    */
    public static synchronized Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }
}
