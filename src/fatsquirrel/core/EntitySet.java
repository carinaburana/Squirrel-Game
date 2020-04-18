package fatsquirrel.core;

public class EntitySet {
    Entity[] entities;

    public EntitySet(int n) {
        entities = new Entity[n];
    }

    public Entity[] getEntitiesArr() {
        return entities;
    }

    public void add(Entity entity) {
        for (int i = 0; i < entities.length; i++) {
            try {
                if (entities[i] != null) {
                    break;
                }
                ;
            } catch (NullPointerException e) {
                entities[i] = entity;
            }
        }
    }

    public void remove(Entity e) {
        for (int i = 0; i < entities.length; i++) {
            try {
                if (e.equals(entities[i])) {
                    entities[i] = null;
                    return;
                }
            } catch (NullPointerException ignored) {
            }
        }
    }


    public Entity getEntity(XY pos) {
        for (int i = 0; i < entities.length; i++) {
            if (entities[i].getXy() == pos)
                return entities[i];
        }
        return null;
    }

    /*
    public void remove(de.hsa.games.fatsquirrel.core.XY pos){
        for(int i = 0; i< entities.length; i++){
            if(entities[i].getXy() == pos){
                entities[i] = null;
                return;
            }
        }
    }
*/
    //checkt für alle Entities ob zufällige Bewegung möglich ist + setzt Zug
    public void nextStep(Entity[] allEntitiesOnField, Board gameBoard) {
        XY newPos = null;
        for (Entity e : allEntitiesOnField) {
            boolean check = true;
            while (check) {
                newPos = e.nextStep();
                if (gameBoard.inRange(newPos)) {
                    check = false;
                }
            }
            try {
                e.setXy(newPos);
            } catch (NullPointerException ignored) {
            }
        }
    }


    public int generateId() {
        int id;
        for (id = 0; id < entities.length; id++) {
            try {
                if (entities[id] == null)
                    return id;
            } catch (NullPointerException e) {
                return id;
            }
        }
        return id;
    }

    public void fillBoard(Board gameBoard) {
        //walls horizontal
        for (int x = 0; x < gameBoard.getWidth(); x++) {
            Wall wall = new Wall(new XY(x, 0), generateId());
            add(wall);
            gameBoard.updateGameBoard(entities);
        }
        //walls vertical
        for (int y = 0; y < gameBoard.getHeight(); y++) {
            Wall wall = new Wall(new XY(0, y), generateId());
            add(wall);
            gameBoard.updateGameBoard(entities);
        }
        //add Player
        HandOperatedMS player = new HandOperatedMS(gameBoard.generateXY(), generateId());
        add(player);
        gameBoard.updateGameBoard(entities);

        //add number of entities
        for (int counterOfInstances = 0; counterOfInstances < 3; counterOfInstances++) {

            GoodBeast goodBeast = new GoodBeast(gameBoard.generateXY(), generateId());
            add(goodBeast);
            gameBoard.updateGameBoard(entities);

            BadBeast badBeast = new BadBeast(gameBoard.generateXY(), generateId());
            add(badBeast);
            gameBoard.updateGameBoard(entities);

            BadPlant badPlant = new BadPlant(gameBoard.generateXY(), generateId());
            add(badPlant);
            gameBoard.updateGameBoard(entities);

            GoodPlant goodPlant = new GoodPlant(gameBoard.generateXY(), generateId());
            add(goodPlant);
            gameBoard.updateGameBoard(entities);

        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        try {
            for (Entity e : entities) {
                try {
                    if (!e.getType().equals(Wall.getTYPE())) {
                        builder.append(e.toString());
                        builder.append('\n');
                    }
                } catch (NullPointerException ignored) {
                }
            }
        } catch (NullPointerException ignored) {
        }
        return builder.toString();
    }
}
