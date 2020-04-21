import fatsquirrel.core.*;

public class Main {

    public static void main(String[] args) {
        //erzeuge brett und best. menge entities
        BoardConfig config = new BoardConfig();
        EntitySet entities = new EntitySet(config);
        Board board = new Board(config, entities);
        board.fillBoard();
        board.updateGameBoard(entities.getEntitiesArr());
        Game game;

        //loop
        for (int testRounds = 0; testRounds < 10; testRounds++) {
            entities.nextStep(board);
            board.updateGameBoard(entities.getEntitiesArr());
            board.flatten(entities);

        }
    }
}