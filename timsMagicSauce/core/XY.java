package core;

public final class XY  {

    private final int x;
    private final int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static XY randomXY() {
        return new XY((int) (Math.random() * 3) - 1, (int) (Math.random() * 3) - 1);
    }

    public boolean equals(XY other) {
        return this.x == other.getX() && this.y == other.getY();
    }

    public String toString() {
        return "x: " + x + '\n' + "y: " + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public XY add(XY otherXY) {
        return new XY(this.x + otherXY.getX(), this.y + otherXY.getY());
    }
}
