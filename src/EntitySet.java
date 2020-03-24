public class EntitySet {
    Entity[] allEntitiesOnField;

    public EntitySet(int maxNumberOfEntities) {
        allEntitiesOnField = new Entity[maxNumberOfEntities];
    }


    public void add(Entity entity) {
        for (int i = 0; i < allEntitiesOnField.length; i++) {
            try {
                if (allEntitiesOnField[i] == null) {
                    allEntitiesOnField[i] = entity;
                    break;
                }
            } catch (NullPointerException e) {
                allEntitiesOnField[i] = entity;
            }
        }
    }

    public void remove(Entity entity) {
        for (int i = 0; i < allEntitiesOnField.length; i++) {
            if (entity.equals(allEntitiesOnField[i])) {
                allEntitiesOnField[i] = null;
                return;
            }
        }
    }

    public void nextStep(Entity[] allEntitiesOnField) {
        for (Entity e : allEntitiesOnField)
            e.nextStep();
    }


    public int generateId() {
        int id = 0;
        try {
            for (id = 0; id <= allEntitiesOnField.length; id++) {
                try {
                    if (allEntitiesOnField[id] == null)
                        return id;
                } catch (NullPointerException e) {
                    return id;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("board already filled with allEntitiesOnField! (randomID)");
        }
        return id;
    }

    public XY generateXY(GameBoard gameBoard) {
        Entity[][] entityArray = gameBoard.getGameBoard();
        int x = 0, y = 0;
        try {
            for (x = 0; x <= gameBoard.getWidth(); x++) {
                for (y = 0; y <= gameBoard.getHeight(); y++) {
                    try {
                        if (entityArray[x][y] == null)
                            return new XY(x, y);
                    } catch (NullPointerException e) {
                        return new XY(x, y);
                    }
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("board already filled with allEntitiesOnField! (randomXY)");
        }
        return new XY(0, 0);
    }


    public void fillBoardRandomly(GameBoard gameBoard) {

        for (int counterOfInstances = 0; counterOfInstances <= 3; counterOfInstances++) {
            Wall wall = new Wall(generateXY(gameBoard), generateId());
            add(wall);
            gameBoard.updateGameBoard(allEntitiesOnField);
            GoodBeast goodBeast = new GoodBeast(generateXY(gameBoard), generateId());
            add(goodBeast);
            gameBoard.updateGameBoard(allEntitiesOnField);
            BadBeast badBeast = new BadBeast(generateXY(gameBoard), generateId());
            add(badBeast);
            gameBoard.updateGameBoard(allEntitiesOnField);
            BadPlant badPlant = new BadPlant(generateXY(gameBoard), generateId());
            add(badPlant);
            gameBoard.updateGameBoard(allEntitiesOnField);
            GoodPlant goodPlant = new GoodPlant(generateXY(gameBoard), generateId());
            add(goodPlant);
            gameBoard.updateGameBoard(allEntitiesOnField);


        }
    }

    public Entity[] getAllEntitiesOnField() {
        return allEntitiesOnField;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

       try{ for (Entity e : allEntitiesOnField) {
            builder.append(e.toString());
            builder.append('\n');
        }}
       catch (NullPointerException e){}

        return builder.toString();
    }


}
