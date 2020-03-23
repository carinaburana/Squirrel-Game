public abstract class Entity {

    private static int id;
    private int energy;
    private XY xy;

    public Entity(XY startXy, int id, int energy) {
        this.xy=startXy;
        this.id=id;
        this.energy=energy;
    }

    public int getId() {
        return id;
    }

    public int getEnergy() {
        return energy;
    }

    public XY getXy() {
        return xy;
    }


    public void setXy(XY xy){
        this.xy=xy;
    }


    public void updateEnergy(int deltaEnergy){
        energy+=deltaEnergy;   }



}





