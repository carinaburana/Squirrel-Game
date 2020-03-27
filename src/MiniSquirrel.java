public class MiniSquirrel extends MasterSquirrel{

    private final MasterSquirrel PATRON;
    private final static String TYPE = "ms";

    public MiniSquirrel(int id, XY startXy, int energy, MasterSquirrel patron) {
        super(startXy, id, TYPE, energy);
        this.PATRON = patron;
    }

    public MasterSquirrel getPATRON() {
        return PATRON;
    }



    }
