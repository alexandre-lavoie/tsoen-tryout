package immortuos.solution;

import immortuos.utils.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private List<Survivor> registry;
    /**
     * Create a new application. You must not change this constructor's
     * signature.
     */
    public Application() {
        this.registry = new ArrayList<Survivor>();
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
        Event registered = new Event(EventType.REGISTERED.toString(), survivor.getLocation());
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
        // Get event enum
        EventType eventType = EventType.valueOf(event.getType().toUpperCase());

        // For every registered survivor
        for (Survivor survivor : this.registry){
            // Get survivor type
            SurvivorType survivorType = SurvivorType.valueOf(survivor.getType().toUpperCase());
            
            // If the distance to the event is less than the max distance to listen for the event.
            // We get -1 when the event and survivor type don't match, therefore skips!
            if(getDistance(event.getLocation(), survivor.getLocation()) <= getMaxDistance(eventType, survivorType)){
                switch(eventType){
                    case ZOMBIE:
                        switch(survivorType){
                            case CITIZEN:
                                // Run condition for citizen
                                Event run = new Event(EventType.RUN.toString(), getRunPosition(event.getLocation(), survivor.getLocation()));
                                survivor.notify(run);
                                break;
                            default:
                                survivor.notify(event);
                                break;
                        }
                        break;
                    default:
                        survivor.notify(event);
                }
            }
        } 
    }

    /**
     * Get distance between two points.
     * @param from First point.
     * @param to Second point.
     * @return Distance between points.
     */
    public static double getDistance(Point from, Point to){
        return Math.sqrt(Math.pow((to.getX()-from.getX()),2) + Math.pow((to.getY()-from.getY()),2));
    }

    /**
     * Get next position for to to run from.
     * @param from Position of zombie.
     * @param to Position of player.
     * @return New player position.
     */
    public static Point getRunPosition(Point from, Point to){
        return new Point(to.getX()+(to.getX()-from.getX())/getDistance(from, to), to.getY()+ (to.getY()-from.getY())/getDistance(from, to));
    }

    /**
     * Get the distance according to the event and survivor type.
     * -1 if not possible option.
     * @param eventType Type of event being called.
     * @param survivorType Type of survivor being called.
     * @return Max distance to notify. -1 if there is no max distance.
     */
    public static int getMaxDistance(EventType eventType, SurvivorType survivorType){
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