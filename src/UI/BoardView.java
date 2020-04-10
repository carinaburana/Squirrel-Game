package UI;

import fatsquirrel.core.Entity;
import fatsquirrel.core.XY;

public interface BoardView {

    Entity getEntityType(int x, int y);
    XY getSize();

}
