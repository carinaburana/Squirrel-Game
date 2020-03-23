public abstract class Entity {
    
    private int id;
    private int energy;
    private XY xy;
    
    public Entity(XY startXy) {
        this.xy=startXy;
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

    public void setID(int id){
        this.id =id;
    }

    public void updateEnergy(int energy, int deltaEnergy){
        energy+=deltaEnergy;   }



}



