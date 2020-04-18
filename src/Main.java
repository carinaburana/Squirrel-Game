import fatsquirrel.core.*;

public class Main {

    public static void main(String[] args) {


        //erzeuge brett und best. menge entities
        BoardConfig config = new BoardConfig();
        Board gameBoard = new Board(config);
        EntitySet entities = new EntitySet(config);
        entities.fillBoard(config);

        //loooooooooop

        for (int testRounds = 0; testRounds < 20; testRounds++) {

            System.out.println(entities.toString());
            gameBoard.updateGameBoard(entities.getEntitiesArr());
            System.out.println(gameBoard.toString());


            for (int i = 0; i <= entities.getEntitiesArr().length - 1; i++) {
                Entity e = entities.getEntitiesArr()[i];

                try {
                    boolean checker = true;
                    while (checker) {
                        XY newPos = e.nextStep();
                        try {
                            if (gameBoard.inRange(newPos)) {
                                checker = false;
                            }
                            if (gameBoard.posIsEmpty(newPos)
                                    || e.getType().equals(BadPlant.getTYPE())
                                    || e.getType().equals(GoodPlant.getTYPE())
                                    || e.getType().equals(Wall.getTYPE())) {
                                e.setXy(newPos);
                            } else {
                                e.collision(gameBoard.getEntity(newPos), gameBoard, entities);
                            }
                        } catch (NullPointerException ignored) {
                        }
                    }
                } catch (NullPointerException ignored) {
                }
                Entity[] allEntitiesOnField = entities.getEntitiesArr();
            }
        }
    }
}
