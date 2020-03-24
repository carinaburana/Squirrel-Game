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
                break;
            case 2:
                y--;
                break;
            case 3:
                y--;
                x++;
                break;
            case 4:
                x--;
                break;
            case 5:
                x++;
                break;
            case 6:
                x--;
                y++;
                break;
            case 7:
                y++;
                break;
            case 8:
                x++;
                y++;
                break;
        }
        new XY(x, y);


    }

    @Override
    public String toString() {
        return "Entity{" +
                "energy=" + energy +
                ", xy=" + xy +
                '}';
    }

    public void updateEnergy(int deltaEnergy) {
        energy += deltaEnergy;
    }


}





