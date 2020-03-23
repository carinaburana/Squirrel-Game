public class MiniSquirrel extends MasterSquirrel{

private  MasterSquirrel patron;

    public MiniSquirrel(int id, XY startXy, int energy, MasterSquirrel patron) {
        super(startXy, id, energy);
        this.patron= patron;
    }

    public MasterSquirrel getPatron() {
        return patron;
    }



    }
