package core;

public class GoodPlant extends Entity {

    private static final int DEFAULT_ENERGY = 100;

    public GoodPlant(int id, XY position) {
        super(id, DEFAULT_ENERGY, position);
    }

    public void nextStep() {

    }

    public String toString() {
        return "GoodPlant" + '\n' +
                super.toString();
    }


}
