public class BadBeast extends Entity {

    private final static int START_ENERGY = -200;
    private final static String TYPE = "BB";

    public BadBeast(XY startXy, int id) {
        super(startXy, id, TYPE, START_ENERGY);

    }
}
