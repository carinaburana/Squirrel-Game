package core;

public abstract class Entity {

    private final int ID;
    private int energy;
    private XY position;

    public Entity(int id, int energy, XY position) {
        this.ID = id;
        this.energy = energy;
        this.position = position;
    }


    public int getID() {
        return ID;
    }

    public int getEnergy() {
        return energy;
    }

    public XY getPosition() {
        return position;
    }

    public void updateEnergy(int delta) {
        energy += delta;
    }

    public void setPosition(XY position) {
        this.position = position;
    }

    public String toString() {
        return  position.toString() + '\n' +
                "energy: " + getEnergy();
    }

    public boolean equals(Entity e) {
        return this.ID == e.getID();
    }

    public boolean hasCollided(Entity entity) {
        if (position.getX() == entity.getPosition().getX() &&
                position.getY() == entity.getPosition().getY()) {
            return true;
        }
        return false;
    }

    public boolean collidesWith(Entity entity) {
        return true;
    }
}
