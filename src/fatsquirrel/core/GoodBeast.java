package fatsquirrel.core;

public class GoodBeast extends Character {

    private final static int START_ENERGY = 200;
    private final static String TYPE = "GB";
    private int timeOut;


    public GoodBeast(XY startXy) {
        super(startXy, TYPE, START_ENERGY);
        this.timeOut = 0;
    }

    public static int getStartEnergy() {
        return START_ENERGY;
    }

/*
    public void nextStep() {  //random bewegung
        if (timeOut > 0) {
            timeOut--;

        }else{
            timeOut = 4;
        }
        super.nextStep();
    }
*/
    public void nextStep() { //gezielte bewegung
        XY moveDirection = getXy().moveFromPlayer(getXy().moveDirectionTowardsPlayer(getXy()));
        if (timeOut > 0) {
            timeOut--;
        }else {
            try{
            this.getXy().addDirection(moveDirection);
        }catch(NullPointerException n){
                super.nextStep();
            }
            timeOut = 4;
        }
    }

    public static String getTYPE() {
        return TYPE;
    }
}

