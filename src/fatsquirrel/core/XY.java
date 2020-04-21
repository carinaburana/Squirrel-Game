package fatsquirrel.core;

import java.util.Objects;

public final class XY {
    private int x;
    private int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX(){ return x; }

    public int getY(){ return y; }

    public XY randomMoveDirection(){
        int zufall;
        zufall = (int) (Math.random() * 4) + 1;
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

    public XY moveDirectionTowardsPlayer(XY posOfPlayer){
        int x_vec=0;
        int y_vec=0;
        if(x<posOfPlayer.getX()) {
            x_vec++;
        }
        if(x>posOfPlayer.getX()) {
            x--;
        }
        if(y<posOfPlayer.getY()){
            y++;
        }
        if(y>posOfPlayer.getY()){
            y--;
        }
        return new XY(x_vec, y_vec);
    }

    public XY moveFromPlayer(XY posOfPlayer){
        XY negVector = moveDirectionTowardsPlayer(posOfPlayer);
        int x_vec=0;
        int y_vec=0;
        if(negVector.getX() !=0){
            x_vec = negVector.getX() * -1;
        }
        if(negVector.getY() != 0){
            y_vec = negVector.getY() * -1;
        }
        return new XY(x_vec, y_vec);
    }

    public void addDirection(XY vector){
        this.x+=vector.getX();
        this.y+=vector.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XY xy = (XY) o;
        return x == xy.x &&
                y == xy.y;
    }

    @Override
    public String toString() {
        return "de.hsa.games.fatsquirrel.core.XY{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
