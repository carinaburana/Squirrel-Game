package core;

public class Wall extends Entity {

    private static final int DEFAULT_ENERGY = -10;

    public Wall(int id, XY position) {
        super(id, DEFAULT_ENERGY, position);
    }

    public String toString() {
        return "Wall" + '\n' +
                super.toString();
    }

    public void nextStep() {

    }


}
