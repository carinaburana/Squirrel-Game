public class BadPlant extends Entity {
    
    private final static int START_ENERGY=-100;

    public BadPlant(XY startXy,int id) {
        super(startXy,id,START_ENERGY);
    }

    @Override
    public void nextStep() {

    }
}