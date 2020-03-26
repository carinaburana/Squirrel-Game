import java.security.PublicKey;
import java.util.Arrays;

public class GameBoard {
    int height;
    int width;
    private Entity[][] gameBoard;

    public GameBoard(int width, int height) {
        Entity[][] gameBoard = new Entity[width][height];
        this.width = width;
        this.height = height;
    }

    public XY randomizeXY(){
        int x = (int) (Math.random()*width);
        int y = (int) (Math.random()*height);

        return new XY(x,y);
    }

    public boolean checkIfPosIsEmpty(XY position){
        Entity[][] entityArray = this.getGameBoard();
        return (entityArray[position.getX()][position.getY()]==null);

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    /*   public Entity getEntity(XY pos) {
           if (notInRange(pos))
               return null;
           return gameBoard[pos.getX()][pos.getY()];
       }*/
    public Entity[][] getGameBoard() {
        return gameBoard;
    }

    public void updateGameBoard(Entity[] allEntitiesOnField) {
       // Entity[] allEntitiesOnField = entitySet.getAllEntitiesOnField();
        for (Entity entity : allEntitiesOnField) {
            try {
                setEntity(entity);
            } catch (NullPointerException ignored) {
            }
        }
    }

    public void setEntity(Entity entity) {
        XY pos = entity.getXy();
       if(!notInRange(pos))
        gameBoard[pos.getX()][pos.getY()] = entity;
       else
           System.out.println("not in range");
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
