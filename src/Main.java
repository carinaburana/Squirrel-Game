public class Main {

    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard(10, 10);
        EntitySet testSetOfEntities = new EntitySet(gameBoard.height*gameBoard.width);
        testSetOfEntities.fillBoardRandomly(gameBoard);
        Entity[] allEntitiesOnField = testSetOfEntities.getAllEntitiesOnField();

//loooooooooop
        for (int testRounds = 0; testRounds < 3; testRounds++) {
            System.out.println(testSetOfEntities.toString());
//make them move
            for (int i = 0; i <= allEntitiesOnField.length-1; i++) {
                Entity entity = allEntitiesOnField[i];
               try {
                    entity.nextStep();
               } catch (NullPointerException e) { }
            }
        }

    }
}

