package fatsquirrel.core;

public class BadPlant extends Entity {
    
    private final static int START_ENERGY=-100;
    private final static String TYPE = "BP";

    public BadPlant(XY startXy,int id) {
        super(startXy,id, TYPE, START_ENERGY);
    }

    public static String getTYPE() {
        return TYPE;
    }


    public XY nextStep() {
return this.getXy();
    }
}