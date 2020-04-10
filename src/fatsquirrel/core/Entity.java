package fatsquirrel.core;

public abstract class Entity {

    private int id;
    private int energy;
    private XY xy;
    private String type;

    protected Entity(XY startXy, int id, String type, int energy) {
        this.xy = startXy;
        this.id = id;
        this.energy = energy;
        this.type = type;
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

    public String getType() { return type; }

    public void setXy(XY xy) { this.xy = xy; }

    public void updateEnergy(int deltaEnergy) {}

    public void nextStep(EntityContext context) { }

    public XY nextStep() {
        int zufall;
        zufall = (int) (Math.random() * 4) + 1;
        int x = this.getXy().getX();
        int y = this.getXy().getY();

       switch (zufall) {
            case 1: x--; y--; break;
            case 2: y--; break;
            case 3: y--; x++; break;
            case 4: x--; break;
            case 5: x++; break;
            case 6: x--; y++; break;
            case 7: y++; break;
            case 8: x++; y++; break;
            default:
           }

        return new XY(x, y);
    }

    public void collision(Entity eOnNewPos, Board board, EntitySet entities) { }

    public String toString() {
        return "de.hsa.games.fatsquirrel.core.Entity{" +
                "id=" + id +
                " energy=" + energy +
                ", xy=" + xy +
                ", type='" + type + '\'' +
                '}';
    }
}
