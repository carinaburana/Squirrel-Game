public abstract class Entity {
    
    protected int id;
    protected int energy;
    protected XY xy;
    
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
    
}
