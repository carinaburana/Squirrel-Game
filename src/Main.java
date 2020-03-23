public class Main {

    public static void main(String[] args) {

GameBoard gameBoard = new GameBoard();
        EntitySet testSetOfEntities = new EntitySet();
        testSetOfEntities.fillBoardRandomly();
        Entity[] allEntitiesOnField = testSetOfEntities.getAllEntitiesOnField();

//loooooooooop
        for (int testRounds = 0; testRounds < 10; testRounds++) {
            testSetOfEntities.gameBoard.toString();
//make them move
            for (int i = 0; i <= allEntitiesOnField.length; i++) {
                Entity entity = allEntitiesOnField[i];
                entity.nextStep();
            }

        }
    }
}
