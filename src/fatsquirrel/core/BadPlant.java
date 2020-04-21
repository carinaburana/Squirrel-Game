package fatsquirrel.core;

public class BadPlant extends Entity {
    
    private final static int START_ENERGY=-100;
    private final static String TYPE = "BP";
    private XY xy;

    public BadPlant(XY startXy) {
        super(startXy, TYPE, START_ENERGY);
    }

    public static String getTYPE() {
        return TYPE;
    }

    public void nextStep() { }
}