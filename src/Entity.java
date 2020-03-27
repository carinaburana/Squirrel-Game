public abstract class Entity {

    private static int id;
    private int energy;
    private XY xy;

    public String getType() {
        return type;
    }

    private String type;

    public Entity(XY startXy, int id, String type, int energy) {
        this.xy = startXy;
        Entity.id = id;          //Enitiy.id weil irgendwas static blabla (note to self, lo
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

    public void setXy(int x, int y) {
        this.xy = new XY(x, y);
    }
    public void setXy(XY xy) { this.xy = xy;
    }

    public XY nextXY() {
        int zufall = (int) (Math.random() * 8) + 1;
        int x = getXy().getX();
        int y = getXy().getY();

        switch (zufall) {
            case 1: x--; y--; break;
            case 2: y--; break;
            case 3: y--; x++; break;
            case 4: x--; break;
            case 5: x++; break;
            case 6: x--; y++; break;
            case 7: y++; break;
            case 8: x++; y++; break;
        }
        System.out.println(x +" "+ y);
        return new XY(x, y);


    }

    @Override
    public String toString() {
        return "Entity{" +
                "energy=" + energy +
                ", xy=" + xy +
                ", type='" + type + '\'' +
                '}';
    }

    public void updateEnergy(int deltaEnergy) {
        energy += deltaEnergy;
    }


}





