package fatsquirrel.core;

public class GoodPlant extends Entity {

    private final static int START_ENERGY = 100;
    private final static String TYPE = "GP";

    public static String getTYPE() { return TYPE; }

    public GoodPlant(XY startXy) {
        super(startXy, TYPE, START_ENERGY);
    }

    public void nextStep() { }
}


