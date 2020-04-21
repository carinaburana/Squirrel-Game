package fatsquirrel.core;

public class MiniSquirrel extends MasterSquirrel {

    private final MasterSquirrel PATRON;
    private final static String TYPE = "ms";
    private int energy;

    public MiniSquirrel(XY startXy, int energy, MasterSquirrel patron) {
        super(startXy, TYPE, energy);
        this.PATRON = patron;
    }

    public MasterSquirrel getPATRON() {
        return PATRON;
    }

    public static String getTYPE() { return TYPE; }

    public void updateEnergy(int deltaEnergy) {
        this.energy += deltaEnergy;
    }

    public void nextStep(XY moveDirection) { //gezielte bewegung
        energy--;
        try {
            this.getXy().addDirection(moveDirection);
        } catch (NullPointerException n) {
            this.setXy(this.getXy().randomMoveDirection());
        }


    }
}
