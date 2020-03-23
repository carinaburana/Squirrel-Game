import java.security.PublicKey;
import java.util.Arrays;

public class GameBoard {
    int height;
    int width;
    private Entity[][] gameBoard;

    public GameBoard(int width, int height){
        Entity[][] gameBoard = new Entity[width][height];
        this.width=width;
        this.height=height;

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Entity getEntity(XY pos) {
        if (notInRange(pos))
            return null;
        return gameBoard[pos.getX()][pos.getY()];
    }

    public Entity[][] getGameBoard(){
        return gameBoard;
    }
    
    public void setEntity(XY pos, Entity entity) {
        
        if (notInRange(pos))
            return;
        Entity boardField = this.gameBoard[pos.getX()][pos.getY()];
        if (boardField == null)
            gameBoard[pos.getX()][pos.getY()] = entity;
    }
    
    public boolean notInRange(XY pos) {
        return pos.getX() < 0 || pos.getX() >= this.width ||
                pos.getY() < 0 || pos.getY() >= this.height;
    }

    public String toString() {
        return "BoardGame{" +
                "gameBoard=" + Arrays.toString(gameBoard) +
                '}';
    }
}
