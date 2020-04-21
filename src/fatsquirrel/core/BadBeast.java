package fatsquirrel.core;

public class BadBeast extends Character {

    private final static int START_ENERGY = -200;
    private final static String TYPE = "BB";
    int timeOut;
    int bites;

    public int getBites() {
        return bites;
    }

    public void setBites(int bites) {
        this.bites = bites;
    }

    public BadBeast(XY startXy) {
        super(startXy, TYPE, START_ENERGY);
        this.timeOut = 0;
        this.bites = 7;
    }


    public static String getTYPE() {
        return TYPE;
    }

    public void reduceBites() {
        bites--;
    }

    public void nextStep() {
        XY moveVector =  getXy().moveDirectionTowardsPlayer(getXy());
        if (timeOut > 0) {
            timeOut--;
        } else {
            try {
                getXy().addDirection(moveVector);
            } catch (NullPointerException n) {
                super.nextStep();
            }
            timeOut=4;
        }
    }
}

