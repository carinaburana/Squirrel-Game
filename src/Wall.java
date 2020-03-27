public class Wall extends Entity{

    public final static int ENERGY= -10;
    private final static String TYPE = "WA";

    public Wall(XY startXy, int id){
        super(startXy, id, TYPE, ENERGY);
    }

    public XY nextXY(){
        return this.getXy();

    }
}
