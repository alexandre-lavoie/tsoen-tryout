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
public class Soldier implements Survivor {
    private final Point location;
    private final String type;
    
    public Soldier(String type, Point location) {
        this.location = location;
        this.type = type;
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
