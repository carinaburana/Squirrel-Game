public class EntitySet {

    GameBoard gameBoard = new GameBoard(10, 10);
    int height = gameBoard.getHeight();
    int width =  gameBoard.getWidth();

    Entity[] allEntitiesOnField = new Entity[width * height];

    public int generateId() {
        int id = 0;
        try {
            for (id = 0; id <= allEntitiesOnField.length; id++) {
                try {
                    if (allEntitiesOnField[id] == null)
                        return id;
                }catch(NullPointerException e){
                    return id;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("board already filled with entities! (randomID)"); }
        return id;
    }

    public XY generateXY(Entity[][] gameBoard){
        int x=0, y=0;
        try{
        for (x=0; x<= width; x++){
            for(y=0; y<= height; y++) {
                try {
                    if (gameBoard[x][y] == null)
                        return new XY(x, y);
                } catch (NullPointerException e) {
                    return new XY(x, y);
                }
            }

        }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("board already filled with entities! (randomXY)");
        }
            return new XY(0, 0);
        }


    public void fillBoardRandomly(){
        Entity[][] board = gameBoard.getGameBoard();
        for (int counterOfInstances = 0; counterOfInstances<=5; counterOfInstances++){

            Wall wall = new Wall(generateXY(board), generateId());
            gameBoard.setEntity(wall.getXy(), wall);
           GoodBeast goodBeast = new GoodBeast(generateXY(board), generateId());
           gameBoard.setEntity(goodBeast.getXy(), goodBeast);
           BadBeast badBeast = new BadBeast(generateXY(board), generateId());
           gameBoard.setEntity(badBeast.getXy(), badBeast);
          BadPlant badPlant = new BadPlant(generateXY(board), generateId());
          gameBoard.setEntity(badPlant.getXy(), badPlant);
          GoodPlant goodPlant = new GoodPlant(generateXY(board), generateId());
          gameBoard.setEntity(goodPlant.getXy(), goodPlant);
          wall = new Wall(generateXY(board), generateId());
        gameBoard.setEntity(wall.getXy(), wall);
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
