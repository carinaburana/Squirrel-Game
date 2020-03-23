package console;

import core.BoardView;
import util.ui.console.Command;

public interface UI {

    void render(BoardView view);
    Command getCommand();
    void message(String message);

}
