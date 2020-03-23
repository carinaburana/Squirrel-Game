package core;

import core.Board;
import core.FlattenedBoard;

public class State {

    private int highscore = 0;
    private XY moveCommand;
    private Board board;
    private FlattenedBoard flatBoard;

    public State(Board board) {
        this.board = board;
        flatBoard = board.flatten();
    }

    public void update() {

    }

    public FlattenedBoard flattenedBoard() {
        return flatBoard;
    }

    public XY getMoveCommand() {
        return moveCommand;
    }

    public void setMoveCommand(XY command) {
        moveCommand = command;
    }

    public Board getBoard() {
        return board;
    }

}
