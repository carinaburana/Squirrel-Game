package fatsquirrel.core;

import UI.ConsoleUI;

public abstract class Game {
    BoardConfig config = new BoardConfig();
    EntitySet entities = new EntitySet(config);
    Board board = new Board(config, entities);

    public Game() {
        init();
        run();
    }

    public abstract void render();
    //stellt Spielzustand auf Ausgabemedium dar


    public abstract void processInput();
    //verarbeitet Benutzereingaben

    public void update() {
        //verändert Spielzustandt(evtl +Eingaben) bereitet render vor
    }

    public void init(){
        board.fillBoard();
        board.updateGameBoard(entities.getEntitiesArr());

    }

    //späterer loop
    public void run() {
        while (true) {
            render();
            processInput();
            update();
        }
    }

}
