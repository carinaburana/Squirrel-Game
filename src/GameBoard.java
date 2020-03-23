import java.util.Arrays;

public class GameBoard {
    private static final int WIDTH=10;
    private static final int HEIGHT=10;
    private Entity[][] gameBoard=new Entity[WIDTH][HEIGHT];
    
    
    public int getWidth(){
        return gameBoard.length; }
    
    public int getHeight(){
        return  gameBoard[0].length; }
    
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
        Entity boardField = gameBoard[pos.getX()][pos.getY()];
        if (boardField == null)
            gameBoard[pos.getX()][pos.getY()] = entity;
    }
    
    public static boolean notInRange(XY pos) {
        return pos.getX() < 0 || pos.getX() >= WIDTH ||
                pos.getY() < 0 || pos.getY() >= HEIGHT;
    }

    public String toString() {
        return "BoardGame{" +
                "gameBoard=" + Arrays.toString(gameBoard) +
                '}';
    }
}
