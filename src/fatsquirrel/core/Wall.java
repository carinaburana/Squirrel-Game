package fatsquirrel.core;

public class Wall extends Entity {
    private final static int ENERGY = -10;
    private final static String TYPE = "WA";

    public Wall(XY startXy, int id) {
        super(startXy, id, TYPE, ENERGY);
    }

    public static String getTYPE() {
        return TYPE;
    }

    public static int getENERGY() { return ENERGY; }

    public XY nextStep() { return this.getXy(); }


}
