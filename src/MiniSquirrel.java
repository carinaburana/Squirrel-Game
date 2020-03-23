public class MiniSquirrel extends MasterSquirrel{

   public MasterSquirrel patron;

    public MiniSquirrel(int id, XY startXy, MasterSquirrel patron, int energy) {
        super(startXy, id, energy);
        this.patron = patron;
    }
    
    public MasterSquirrel getMasterSquirrel() {
        return patron;
    }


    }
