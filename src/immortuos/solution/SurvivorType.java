package immortuos.solution;

public enum SurvivorType{
    MERCHANT("Merchant"),
    CITIZEN("Citizen"),
    SOLDIER("Solder");

    private String survivor;
 
    SurvivorType(String survivor) {
        this.survivor = survivor;
    }
 
    @Override
    public String toString() {
        return this.survivor;
    }
}