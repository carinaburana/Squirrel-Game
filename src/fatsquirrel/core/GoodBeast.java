package fatsquirrel.core;

public class GoodBeast extends Entity {

    private final static int START_ENERGY = 200;
    private final static String TYPE = "GB";
    private int timeOut;

    public GoodBeast(XY startXy, int id) {
        super(startXy, id, TYPE, START_ENERGY);
        this.timeOut = 0;
    }

    public static int getStartEnergy() {
        return START_ENERGY;
    }

    public XY nextStep() {
        if (timeOut > 0) {
            timeOut--;
            return this.getXy();
        }
        timeOut = 4;
        return super.nextStep();
    }

    public static String getTYPE() {
        return TYPE;
    }
}

