package immortuos.solution;

public enum EventType{
    REGISTERED("registered"),
    WATER("water"),
    TRADE("trade"),
    ZOMBIE("zombie"),
    RUN("run");

    private String event;
 
    EventType(String event) {
        this.event = event;
    }
 
    @Override
    public String toString() {
        return this.event;
    }
}