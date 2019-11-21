/*
 *  Team Software Engineering Tryout
 *  SCS Concordia 
 */
package immortuos.solution;
import immortuos.utils.*;

/**
 * This is an example implementation of Survivor that you can use to
 * manually test your code.
 * @author Felix
 */
public class Citizen implements Survivor {
    private final Point location;
    private final String type;
    
    public Citizen(String type, Point location) {
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
