public class MiniSquirrel extends MasterSquirrel{

    public static int parentID;

    public MiniSquirrel(int id, XY startXy, int parentID, int energy){
        super(startXy, id, energy);
        this.parentID=parentID;
    }


    }
