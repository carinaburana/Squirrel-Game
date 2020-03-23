package core;

public abstract class Squirrel extends Character {

    private int waitTime = 0;

    public Squirrel(int id, int energy, XY position) {
        super(id, energy, position);
    }

    public String toString() {
        return "Squirrel" + '\n' +
                super.toString();
    }

    public boolean collidesWith(Entity entity) {
        updateEnergy(entity.getEnergy());
        return super.collidesWith(entity);
    }

    public void paralyze() {
        waitTime = 3;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void reduceWaitTime() {
        waitTime--;
    }
}
