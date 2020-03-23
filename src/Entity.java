public abstract class Entity {

    private static int id;
    private int energy;
    private XY xy;

    public Entity(XY startXy, int id, int energy) {
        this.xy = startXy;
        this.id = id;
        this.energy = energy;
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

    public void nextStep() {

        int zufall = (int) (Math.random() * 8) + 1;
        int x = getXy().getX();
        int y = getXy().getY();

        switch (zufall) {
            case 1:
                x--;
                y--;
            case 2:
                y--;
            case 3:
                y--;
                x++;
            case 4:
                x--;
            case 5:
                x++;
            case 6:
                x--;
                y--;
            case 7:
                y++;
            case 8:
                x++;
                y++;
        }
        setXy(x, y);


    }


    public void updateEnergy(int deltaEnergy) {
        energy += deltaEnergy;
    }


}





