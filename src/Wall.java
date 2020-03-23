public class Wall extends Entity{

    public final static int ENERGY= -10;

    public Wall(int id, XY startXy){
        super(startXy, id, ENERGY);
    }

    public void nextStep(){

    }
}
