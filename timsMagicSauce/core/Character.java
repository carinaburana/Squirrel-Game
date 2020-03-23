package core;

public abstract class Character extends Entity {

    public Character(int id, int energy, XY position) {
        super(id, energy, position);
    }

    public abstract void nextStep(EntityContext context);

}
