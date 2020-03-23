package main;

import console.ConsoleUI;
import console.UI;
import core.*;

public class Launcher {

    public static void main(String[] args) {
        BoardConfig config = new BoardConfig();
        Board board = new Board(config);
        HandOperatedMasterSquirrel player = new HandOperatedMasterSquirrel(0, new XY(5, 5));
        board.getEntitySet().insert(player);
        State state = new State(board);
        UI ui = new ConsoleUI();
        Game game = new GameImpl(state, ui, player);
        game.run();
    }

}
