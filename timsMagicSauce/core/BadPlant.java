package core;

public class BadPlant extends Entity {

    private static final int DEFAULT_ENERGY = -100;

    public BadPlant(int id, XY position) {
        super(id, DEFAULT_ENERGY, position);
    }

    public void nextStep() {

    }

    public String toString() {
        return "de.hsa.games.fatsquirrel.core.BadPlant" + '\n' +
                super.toString();
    }

}
