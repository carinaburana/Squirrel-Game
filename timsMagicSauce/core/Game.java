package core;

import console.UI;

public abstract class Game {

    protected State state;
    protected UI ui;

    public Game(State state, UI ui) {
        this.state = state;
        this.ui = ui;
    }

    public void run() {
        while (true) {
            render();
            processInput();
            update();
        }
    }

    protected abstract void render();

    protected abstract void processInput();

    protected void update() {
        state.getBoard().update(state);
    }


}
