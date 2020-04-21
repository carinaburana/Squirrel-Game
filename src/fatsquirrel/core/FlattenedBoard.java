package fatsquirrel.core;

import UI.BoardView;

import java.util.Arrays;

public class FlattenedBoard implements EntityContext, BoardView {
    private Entity[][] flattenedBoard;
   private int height;
   private int width;
   private EntitySet entities;

    public FlattenedBoard(Board board, EntitySet entities) {
        this.height = board.getHeight();
        this.width = board.getWidth();
        this.entities = entities;
        flattenedBoard = new Entity[width][height];
        try {
            for (Entity e : entities.getEntitiesArr()) {
                flattenedBoard[e.getXy().getX()][e.getXy().getY()] = e;
            }
        } catch (NullPointerException ignored) {
        }
    }


    public String[][] toStringArray() {
        String[][] stringArray = new String[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                stringArray[x][y] = ("|  |");
            }
        }
        for (Entity e : entities.getEntitiesArr()) {
            try {
                stringArray[e.getXy().getX()][e.getXy().getY()] = ("|" + e.getType() + "|");
            } catch (NullPointerException ignored) { }
        }
        return stringArray;
    }

    public Entity[][] getFlattenedBoard() {
        return flattenedBoard;
    }

    public Entity getEntityType(int x, int y) {
        return null;
    }

    public XY getSize() {
        return null;
    }

    public void tryMove(MiniSquirrel miniSquirrel, XY moveDirection) {
    }

    public void tryMove(GoodBeast goodBeast, XY moveDirection) {
    }

    public void tryMove(BadBeast badBeast, XY moveDirection) {
    }

    public void tryMove(MasterSquirrel master, XY moveDirection) {
    }

    public MasterSquirrel nearestPlayerEntity(XY pos) {
        return null;
    }

    public void kill(Entity enitiy) {
    }

    public void killAndReplace(Entity entity) {
    }

    public Entity getEntityType(XY xy) {
        return null;
    }
}


