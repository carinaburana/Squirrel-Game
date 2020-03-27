public class GoodBeast extends Entity {
    private final static int START_ENERGY=200;
    private final static String TYPE = "GB";


    public GoodBeast(XY startXy,int id){
        super(startXy, id, TYPE, START_ENERGY);


    }
}
