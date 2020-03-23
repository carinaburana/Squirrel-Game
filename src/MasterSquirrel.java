
public class MasterSquirrel extends Entity {

    public static final int START_ENERGY=1000;

    public MasterSquirrel(XY startXy,int id){
        super(startXy, id, START_ENERGY);
    }


    //fürs MiniSquirrels :))
    public MasterSquirrel(XY startXy, int id, int energy){
        super(startXy, id, energy);
    }


    public boolean checkMini(Entity entity){
        if(entity instanceof MiniSquirrel) {
            int entityId=entity.getId();

            return (entityId == this.getId());
        }return false;
    }


}