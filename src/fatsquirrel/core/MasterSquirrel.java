package fatsquirrel.core;

public class MasterSquirrel extends Squirrel {

    public static final int START_ENERGY = 1000;
    private final static String TYPE = "MS";
    private int energy = START_ENERGY;

    public MasterSquirrel(XY startXy) {
        super(startXy, TYPE, START_ENERGY);
    }

    //fürs MiniSquirrels :))
    public MasterSquirrel(XY startXy, String type, int energy) {
        super(startXy, type, energy);
    }

    public static String getTYPE() {
        return TYPE;
    }

    public void updateEnergy(int deltaEnergy) {
        this.energy += deltaEnergy;
    }

    public void collision(){}

    public boolean checkMini(Entity entity) {
        if (entity instanceof MiniSquirrel) {
            return (((MiniSquirrel) entity).getPATRON() == this);
        } else return false;

    }

}