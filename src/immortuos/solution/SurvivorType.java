package immortuos.solution;

public enum SurvivorType{
    MERCHANT("merchant"),
    CITIZEN("citizen"),
    SOLDIER("solder");

    private String survivor;
 
    SurvivorType(String survivor) {
        this.survivor = survivor;
    }

    @Override
    public String toString() {
        return this.survivor;
    }
}