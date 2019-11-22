package immortuos.solution;

import immortuos.utils.Survivor;
import immortuos.utils.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
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
        EventType eventType = EventType.valueOf(event.getType());
        SurvivorType[] survivorType = getSurvivorTypeByEventType(eventType);
        
    }

    /**
     * Gets a list of all survivor types in Survivor Type Enum.
     * @return Array of survivor types.
     */
    public List<SurvivorType> getAllSurvivorTypes(){
        return Arrays.asList(SurvivorType.values());
    }

    /**
     * 
     * @param eventType
     * @return
     */
    public List<SurvivorType> getSurvivorTypeByEventType(EventType eventType){
        switch(eventType){
            case WATER:
                return getAllSurvivorTypes();
            case ZOMBIE:
                return Arrays.asList(SurvivorType.CITIZEN, SurvivorType.MERCHANT, SurvivorType.SOLDIER);
            case TRADE:
                return Arrays.asList(SurvivorType.CITIZEN, SurvivorType.MERCHANT);
            default:
                return new ArrayList<SurvivorType>();
        }
    }

    public int getMaxDistance(EventType eventType, SurvivorType survivorType){
        switch(eventType){
            case WATER:
                switch(survivorType){
                    default:
                        return 5;
                }
            case TRADE:
                switch(survivorType){
                    case CITIZEN:
                        return 3;
                    case MERCHANT:
                        return 6;
                    default:
                        return -1;
                }
            case ZOMBIE:
                switch(survivorType){
                    case CITIZEN:
                    case MERCHANT:
                        return 4;
                    case SOLDIER:
                        return 7;
                    default:
                        return -1;
                }
            default:
                return -1;
        }
    }
}
