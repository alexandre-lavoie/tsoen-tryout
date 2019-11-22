/*
 *  Team Software Engineering Tryout
 *  SCS Concordia 
 */
package immortuos.solution;
import immortuos.utils.*;

/**
 * 
 * @author Alex
 */
public class Merchant implements Survivor {
    private final Point location;
    private final String type;
    
    public Merchant(String type, Point location) {
        this.location = location;
        this.type = SurvivorType.MERCHANT.toString();
    }
    
    @Override
    public void notify(Event event) {
        
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public String getType() {
        return type;
    }
    
}
