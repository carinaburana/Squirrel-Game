package core;

public class GoodBeast extends Character {

    private static final int DEFAULT_ENERGY = 200;
    private int waitTime = 0;

    public GoodBeast(int id, XY position) {
        super(id, DEFAULT_ENERGY, position);
    }

    public void nextStep(EntityContext context) {
        if (getWaitTime() == 0) {
            context.tryMove(this, XY.randomXY());
        }
        else {
            reduceWaitTime();
        }
    }

    private void reduceWaitTime() {
        waitTime--;
    }

    public String toString() {
        return "GoodBeast" + '\n' +
                super.toString();
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void updateWaitTime() {
        waitTime = 3;
    }

}
