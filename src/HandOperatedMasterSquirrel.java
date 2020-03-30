public class HandOperatedMasterSquirrel extends MasterSquirrel {


    public static final int START_ENERGY = 1000;
    private final static String TYPE = "PL";


    public static String getTYPE() {
        return TYPE;
    }

    public HandOperatedMasterSquirrel(XY startXy, int id) {

        super(startXy, id, TYPE, START_ENERGY);
    }


    //fürs MiniSquirrels :))
    public HandOperatedMasterSquirrel(XY startXy, int id, String type, int energy) {

        super(startXy, id, type, energy);
    }

    public XY nextXY(GameBoard gameBoard) {
        XY startPos = this.getXy();
        int x = startPos.getX();
        int y = startPos.getY();
        ConsoleIO inputReader = new ConsoleIO();

        char move = inputReader.readInput();
        boolean checker = inputReader.inputMakesSense(move);

        while (!checker) ;
        {
            System.out.println(">>" + move + "<< try again. not w, a, s or d.");
            System.out.println(checker);
            move = inputReader.readInput();
            checker = inputReader.inputMakesSense(move);
        }

        System.out.println("left while loop");
        startPos = new XY(-1, -1);
        while (gameBoard.notInRange(startPos)) {

            switch (move) {
                case 'w':
                    y--;
                    break;
                case 'a':
                    x--;
                    break;
                case 's':
                    y++;
                    break;
                case 'd':
                    x++;
                    break;
            }
        }
        return new XY(x, y);
    }


    public boolean checkMini(Entity entity) {
        if (entity instanceof MiniSquirrel) {
            return (((MiniSquirrel) entity).getPATRON() == this);
        } else return false;

    }

}

