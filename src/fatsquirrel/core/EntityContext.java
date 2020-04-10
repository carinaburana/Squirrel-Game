package fatsquirrel.core;

public interface EntityContext {

    XY getSize();
    void tryMove(MiniSquirrel miniSquirrel, XY moveDirection);
    void tryMove(GoodBeast goodBeast, XY moveDirection);
    void tryMove(BadBeast badBeast, XY moveDirection);
    void tryMove(MasterSquirrel master, XY moveDirection);
    MasterSquirrel nearestPlayerEntity(XY pos);

    void kill(Entity enitiy);
    void killAndReplace(Entity entity);
    Entity getEntityType(XY xy);


}
