public class Main {

    public static void main(String[] args) {

        //erzeuge brett und best. menge entities
        GameBoard gameBoard = new GameBoard(10, 10);
        EntitySet testSetOfEntities = new EntitySet(gameBoard.height * gameBoard.width);

        //füll das board damit
        testSetOfEntities.fillBoardRandomly(gameBoard);

        //entities werden in array gespeichert
        Entity[] allEntitiesOnField = testSetOfEntities.getAllEntitiesOnField();



        //loooooooooop

        for (int testRounds = 0; testRounds < 3; testRounds++) {
            System.out.println(testSetOfEntities.toString());

            for (int i = 0; i <= allEntitiesOnField.length - 1; i++) {
                Entity entity = allEntitiesOnField[i];
                try {
                    //make them move
                    if (entity.getType() != HandOperatedMasterSquirrel.getTYPE()) {
                        XY newPosition = entity.nextXY();
                    entity.setXy(newPosition);}
                    else {
                        XY newPosition = ((HandOperatedMasterSquirrel) entity).nextXY(gameBoard);
                        entity.setXy(newPosition);
                    }
                    gameBoard.updateGameBoard(allEntitiesOnField);

                } catch (NullPointerException e) {
                }
            }
        }

    }
}

