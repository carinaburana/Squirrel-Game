
public class MasterSquirrel extends Entity {

    public static final int START_ENERGY = 1000;
    private final static String TYPE = "MS";

    public MasterSquirrel(XY startXy, int id) {
        super(startXy, id, TYPE, START_ENERGY);
    }


    //fürs MiniSquirrels :))
    public MasterSquirrel(XY startXy, int id, String type, int energy) {

        super(startXy, id, type, energy);
    }


    public boolean checkMini(Entity entity) {
        if (entity instanceof MiniSquirrel) {
            return (((MiniSquirrel) entity).getPATRON() == this);
        } else return false;

    }

}