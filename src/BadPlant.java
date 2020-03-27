public class BadPlant extends Entity {
    
    private final static int START_ENERGY=-100;
    private final static String TYPE = "BP";

    public BadPlant(XY startXy,int id) {
        super(startXy,id, TYPE, START_ENERGY);
    }

    @Override
    public XY nextXY() {
return this.getXy();
    }
}