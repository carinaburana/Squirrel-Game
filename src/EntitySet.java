public class EntitySet {

    GameBoard gameBoard;
    private final int HEIGHT = gameBoard.getHeight();
    private final int WIDTH = gameBoard.getWidth();

    Entity[] allEntitiesOnField = new Entity[WIDTH * HEIGHT];

    public int generateRandomId() {
        int id = 0;
        try {
            for (id = 0; id <= allEntitiesOnField.length; id++) {
                if (allEntitiesOnField[id] == null)
                    return id;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("board already filled with entities! (randomID)"); }
        return id;
    }

    public XY generateRandomXY(Entity[][] gameBoard){
        int x=0, y=0;
        try{
        for (x=0; x<=WIDTH; x++){
            for(y=0; y<=HEIGHT; y++){
                if(gameBoard[x][y]==null)
                   break;
            }
        }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("board already filled with entities! (randomXY)");
        }
            return new XY(x, y);
        }


    public void fillBoardRandomly(){
        Entity[][] board = gameBoard.getGameBoard();
        for (int counterOfInstances = 0; counterOfInstances<=5; counterOfInstances++){
            new Wall(generateRandomXY(board), generateRandomId());
            new GoodBeast(generateRandomXY(board), generateRandomId());
            new BadBeast(generateRandomXY(board), generateRandomId());
            new BadPlant(generateRandomXY(board), generateRandomId());
            new GoodPlant(generateRandomXY(board), generateRandomId());
            new Wall(generateRandomXY(board), generateRandomId());
        }
    }

    public Entity[] getAllEntitiesOnField(){
        return allEntitiesOnField;
    }

    public void add(Entity entity, XY pos) {
        gameBoard.setEntity(pos, entity);
    }


    public void remove(Entity entity, XY pos) {
        gameBoard.setEntity(pos, null);
    }

}
