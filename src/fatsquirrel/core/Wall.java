package fatsquirrel.core;

public class Wall extends Entity {
    private final static int ENERGY = -10;
    private final static String TYPE = "WA";

    public Wall(XY startXy) {
        super(startXy, TYPE, ENERGY);
    }

    public static String getTYPE() {
        return TYPE;
    }

    public static int getENERGY() { return ENERGY; }

    public void nextStep() { }


}
