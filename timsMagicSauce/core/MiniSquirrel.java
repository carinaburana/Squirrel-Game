package core;

public class MiniSquirrel extends Squirrel {

    private MasterSquirrel patron;

    public MiniSquirrel(int id, int energy, XY position, MasterSquirrel patron) {
        super(id, energy, position);
        this.patron = patron;
    }

    public void nextStep(EntityContext context) {
        updateEnergy(-1);
        if (getWaitTime() == 0) {
            context.tryMove(this, XY.randomXY());
        }
        else {
            reduceWaitTime();
        }
    }

    public MasterSquirrel getPatron() {
        return patron;
    }
}
