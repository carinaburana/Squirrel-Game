package core;

public interface EntityContext {

    void tryMove(MasterSquirrel masterSquirrel, XY moveDirection);
    void tryMove(MiniSquirrel miniSquirrel, XY moveDirection);
    void tryMove(GoodBeast goodBeast, XY moveDirection);
    void tryMove(BadBeast badBeast, XY moveDirection);

    void killAndReplace(Entity entity);
    void kill(Entity entity);

    Squirrel nearestPlayerEntity(XY position);

    void spawnMiniSquirrel(MasterSquirrel patron, int energy) throws NotEnoughEnergyException;

}
