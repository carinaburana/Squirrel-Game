
public class MasterSquirrel extends Entity {

    public static final int START_ENERGY=1000;

    public MasterSquirrel(XY startXy,int id){
        super(startXy,id,START_ENERGY);
    }


    //fürs MiniSquirrels :))
    public MasterSquirrel(XY startXy,int id, int energy){
        super(startXy,id,energy);
    }


    protected void spawnMini(XY startXy, int energy){
        MiniSquirrel newMini = new MiniSquirrel(this.id, startXy, energy);
    }

    public boolean checkMini(Entity entity){
        if(entity instanceof MiniSquirrel) {
            return (entity.id == this.id);
        }
        return false;
    }


}