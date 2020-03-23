package core;

public class BadBeast extends Character {

    private int waitTime = 0;
    private int remainingBites = 7;
    private static final int DEFAULT_ENERGY = -150;

    public BadBeast(int id, XY position) {
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

    public int getRemainingBites() {
        return remainingBites;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public String toString() {
        return "BadBeast" + '\n' +
                super.toString();
    }

    private void reduceWaitTime() {
        waitTime--;
    }

    public void reduceBites() {
        remainingBites--;
    }

    public void updateWaitTime() {
        waitTime = 3;
    }

}
