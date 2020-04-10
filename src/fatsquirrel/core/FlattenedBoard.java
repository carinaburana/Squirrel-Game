package fatsquirrel.core;

import UI.BoardView;

public class FlattenedBoard implements  EntityContext, BoardView {
    String [][] flattenedBoard;

    public FlattenedBoard(String [][] flattenedBoard){
        this.flattenedBoard = flattenedBoard; }

    @Override
    public Entity getEntityType(int x, int y) { return null; }

    @Override
    public XY getSize() {
        return null;
    }

    @Override
    public void tryMove(MiniSquirrel miniSquirrel, XY moveDirection) { }

    @Override
    public void tryMove(GoodBeast goodBeast, XY moveDirection) { }

    @Override
    public void tryMove(BadBeast badBeast, XY moveDirection) { }

    @Override
    public void tryMove(MasterSquirrel master, XY moveDirection) { }

    @Override
    public MasterSquirrel nearestPlayerEntity(XY pos) {
        return null;
    }

    @Override
    public void kill(Entity entity) { }

    @Override
    public void killAndReplace(Entity entity) { }

    @Override
    public Entity getEntityType(XY xy) {
        return null;
    }

}
