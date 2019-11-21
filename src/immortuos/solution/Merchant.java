/*
 *  Team Software Engineering Tryout
 *  SCS Concordia 
 */
package immortuos.solution;

/**
 * This is an example implementation of Survivor that you can use to
 * manually test your code.
 * @author Felix
 */
public class Merchant implements Survivor {
    private final Point location;
    private final String type;
    
    public Merchant(String type, Point location) {
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
