public class EntitySet {
    Entity[] allEntitiesOnField;
    
    GameBoard gameBoard = new GameBoard(10, 10);
    int height = gameBoard.getHeight();
    int width =  gameBoard.getWidth();
    
    public EntitySet(){
        allEntitiesOnField=new Entity[height*width];
    }

    
    public EntitySet add(Entity entity) {
        for (Entity e : allEntitiesOnField) {
        try {
            if (e != null && e.equals(entity))
                return this; // return the current object instance
        }catch(NullPointerException n){

        }
        }
        
        for (int i = 0; i < allEntitiesOnField.length; i++) {
            if (allEntitiesOnField[i] == null) {
                allEntitiesOnField[i] = entity;
                break;
            }
        }
        return this;
    }
    
    public void remove(Entity entity) {
        for (int i = 0; i < allEntitiesOnField.length; i++) {
            if (entity.equals(allEntitiesOnField[i])) {
                allEntitiesOnField[i] = null;
                return;
            }
        }
    }
    
    public void nextStep(Entity[]allEntitiesOnField){
        for(Entity e:allEntitiesOnField)
                e.nextStep();
            
    }
    

    public int generateId() {
        int id = 0;
        try {
            for (id = 0; id <= allEntitiesOnField.length; id++) {
                try {
                    if (allEntitiesOnField == null)
                        return id;
                }catch(NullPointerException e){
                    return id;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("board already filled with allEntitiesOnField! (randomID)"); }
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
            System.out.println("board already filled with allEntitiesOnField! (randomXY)");
        }
            return new XY(0, 0);
        }


    public void fillBoardRandomly(){
        Entity[][] board = gameBoard.getGameBoard();
        for (int counterOfInstances = 0; counterOfInstances<=5; counterOfInstances++){

            Wall wall = new Wall(generateXY(board), generateId());
            add(wall);
            GoodBeast goodBeast=new GoodBeast(generateXY(board),generateId());
            add(goodBeast);
            BadBeast badBeast=new BadBeast(generateXY(board),generateId());
            add(badBeast);
            BadPlant badPlant=new BadPlant(generateXY(board),generateId());
            add(badPlant);
            GoodPlant goodPlant=new GoodPlant(generateXY(board),generateId());
            add(goodPlant);
          
          
          
        }
    }

    public Entity[] getAllEntitiesOnField(){
        return allEntitiesOnField;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        for (Entity e : allEntitiesOnField) {
            builder.append(e.toString());
            builder.append('\n');
        }
        
        return builder.toString();
    }

  
}
