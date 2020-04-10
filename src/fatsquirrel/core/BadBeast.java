package fatsquirrel.core;

public class BadBeast extends Entity {

    private final static int START_ENERGY = -200;
    private final static String TYPE = "BB";
    int timeOut;
    int bites;

    public int getBites() { return bites; }

    public void setBites(int bites) {this.bites = bites; }

    public BadBeast(XY startXy, int id) {
        super(startXy, id, TYPE, START_ENERGY);
        this.timeOut = 0;
    this.bites = 7;
    }

    public static String getTYPE() {
        return TYPE;
    }



    public XY nextStep() {
        if(timeOut > 0){
            timeOut--;
            return this.getXy();
        }
        timeOut = 4;
        return super.nextStep();
    }
}

