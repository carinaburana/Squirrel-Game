package core;

public abstract class MasterSquirrel extends Squirrel {

    private static final int DEFAULT_ENERGY = 1000;

    public MasterSquirrel(int id, XY position) {
        super(id, DEFAULT_ENERGY, position);
    }


   public boolean isItMySquirrel(Entity entity) {
        if (entity instanceof MiniSquirrel) {
            if (((MiniSquirrel) entity).getPatron() == this) {
                return true;
            }
        }
        return false;
    }

    public void nextStep(EntityContext context) {
        if (getWaitTime() == 0) {
            context.tryMove(this, XY.randomXY());
        }
        else {
            reduceWaitTime();
        }
    }

}
