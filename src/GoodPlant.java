public class GoodPlant extends Entity {

    private final static int START_ENERGY = 100;
    private final static String TYPE = "GP";

    public GoodPlant(XY startXy, int id) {
        super(startXy, id, TYPE, START_ENERGY);
    }

    public XY nextXY() {
        return this.getXy();
    }
}


