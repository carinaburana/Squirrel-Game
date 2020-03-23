public class Wall extends Entity{
    private final static int START_ENERGY=-10;


    public Wall(XY startXy, int id){
        super(startXy,id,START_ENERGY);
    }
}
