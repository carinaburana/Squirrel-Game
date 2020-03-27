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

    public void nextStep(Entity[] allEntitiesOnField, GameBoard gameBoard) {
        XY newPos = null;
        for (Entity e : allEntitiesOnField) {
            while (gameBoard.notInRange(e.nextXY())) {
                newPos = e.nextXY();
            }
            try {
                e.setXy(newPos);
            } catch (NullPointerException ignored) {
            }
            ;

        }
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


    public void fillBoardRandomly(GameBoard gameBoard) {
        XY position = new XY(0, 0);
        for (int counterOfInstances = 0; counterOfInstances <= 2; counterOfInstances++) {

        /*    Wall wall = new Wall(gameBoard.randomizeXY(), generateId());
            add(wall);
            gameBoard.updateGameBoard(allEntitiesOnField);
*/
            HandOperatedMasterSquirrel player = new HandOperatedMasterSquirrel(gameBoard.randomizeXY(), generateId());
            add(player);
            gameBoard.updateGameBoard(allEntitiesOnField);

            GoodBeast goodBeast = new GoodBeast(gameBoard.randomizeXY(), generateId());
            add(goodBeast);
            gameBoard.updateGameBoard(allEntitiesOnField);

            BadBeast badBeast = new BadBeast(gameBoard.randomizeXY(), generateId());
            add(badBeast);
            gameBoard.updateGameBoard(allEntitiesOnField);
            /*
            BadPlant badPlant = new BadPlant(gameBoard.randomizeXY(), generateId());
            add(badPlant);
            gameBoard.updateGameBoard(allEntitiesOnField);

            GoodPlant goodPlant = new GoodPlant(gameBoard.randomizeXY(), generateId());
            add(goodPlant);
            gameBoard.updateGameBoard(allEntitiesOnField);
  */
        }
    }


    public Entity[] getAllEntitiesOnField() {
        return allEntitiesOnField;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        try {
            for (Entity e : allEntitiesOnField) {
                builder.append(e.toString());
                builder.append('\n');
            }
        } catch (NullPointerException ignored) {
        }

        return builder.toString();
    }


}
