package immortuos.solution;

import immortuos.utils.Survivor;
import immortuos.utils.Event;

import java.util.ArrayList;
import java.util.List;
/**
 * The main application for the solution. Write your code here.
 */
public class Application {

    private List<Survivor> registry = new ArrayList<Survivor>();
    /**
     * Create a new application. You must not change this constructor's
     * signature.
     */
    public Application() {
        // You may write code here.

    }

    /**
     * Called when a new survivor must be added to the system. You must not
     * change this method's signature.
     *
     * @param survivor The survivor to be added.
     * @param type The type of this survivor.
     */
    public void registerSurvivor(Survivor survivor) {
        //Add survivor to registry
        this.registry.add(survivor);

        //Notify Survivor with event registered
        Event registered = new Event(EventType.REGISTERED.toString(),survivor.getLocation());
        survivor.notify(registered);
    }

    /**
     * Called when an event occurs in the area tracked by the system. You must
     * not change this method's signature.
     *
     * @param eventType The type of the event.
     * @param eventLocation The location at which the event occurred.
     */
    public void onEvent(Event event) {
        // Write your code here.
        switch(event)
    }
}
