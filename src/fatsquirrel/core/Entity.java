package fatsquirrel.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    private int id;
    private int energy;
    public XY xy;
    private String type;

    protected Entity(XY startXy, String type, int energy) {
        this.xy = startXy;
        this.energy = energy;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getEnergy() {
        return energy;
    }

    public XY getXy() {
        return xy;
    }

    public String getType() { return type; }

    public void setXy(XY xy) { this.xy = xy; }

    public void setId(int id){ this.id = id; }

    public void updateEnergy(int deltaEnergy) {
        this.energy += deltaEnergy;
    }

    public void nextStep(){ this.xy = xy.randomMoveDirection(); }

    public void collision() {}

    public String toString() {
        return "de.hsa.games.fatsquirrel.core.Entity{" +
                "id=" + id +
                " energy=" + energy +
                ", xy=" + xy +
                ", type='" + type + '\'' +
                '}';
    }
}
