package fatsquirrel.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
   private Entity[][] gameBoard;
   private BoardConfig config;
   private EntitySet entities;
    private int maxNumOfBB;
    private int maxNumOfGB;
    private int maxNumOfGP;
    private int maxNumOfBP;
    private int maxNumOfFreeWalls;
    private int height;
    private int width;


    public Board(BoardConfig config, EntitySet entities) {
        this.config = config;
        this.entities = entities;
        this.height = config.getHeight();
        this.width = config.getWidth();
        this.gameBoard =  gameBoard();
    }

    public Entity[][] gameBoard() {
        Entity[][] gameBoard = new Entity[config.getWidth()][config.getHeight()];
        Entity[] array = entities.getEntitiesArr();
        for (int i = 0; i < array.length; i++) {
            try {
                gameBoard[array[i].getXy().getX()][array[i].getXy().getY()] = array[i];
            } catch (NullPointerException ignored) {
            }
        }
        return gameBoard;
    }

    public Entity[][] getGameBoard() {
        return gameBoard;
    }

    private void setConfigNumbers(){
        HashMap<String, Integer> entitiyMap = config.getEntityMap();
        for(String key : entitiyMap.keySet()){
                switch (key){
                    case "GoodPlant":
                        this.maxNumOfGP = entitiyMap.get(key);
                        break;
                    case "BadPlant":
                        this.maxNumOfBP = entitiyMap.get(key);
                        break;
                    case "GoodBeast":
                        this.maxNumOfGB = entitiyMap.get(key);
                        break;
                    case "BadBeast":
                        this.maxNumOfBB = entitiyMap.get(key);
                        break;
                    case "FreeWalls":
                        this.maxNumOfFreeWalls = entitiyMap.get(key);
                        break;
                }
            }
        }

    public EntitySet getEntitySet() {
        return entities;
    }

    public int getHeight() {
        return config.getHeight();
    }

    public int getWidth() {
        return config.getWidth();
    }

    public Entity getEntity(XY pos) {
        return entities.getEntity(pos);
    }

    private void setEntity(Entity e) {
        XY pos = e.getXy();
        if (inRange(pos)) {
            if (posIsEmpty(pos)) {
                entities.add(e);
                gameBoard[pos.getX()][pos.getY()] = e;
            }
            }
            //collision
            else {
            }
        }


    public void fillBoard() {
        drawWalls(height, width);
        spawnEntities(config.getEntityMap());
    }

    private void drawWalls(int height, int width) {
        //walls horizontal
        for (int x = 0; x < width; x++) {
            setEntity(new Wall(new XY(x, 0)));
            setEntity(new Wall(new XY(x, height - 1)));
        }
        //walls vertical
        for (int y = 1; y < height - 1; y++) {
            setEntity(new Wall(new XY(0, y)));
            setEntity(new Wall(new XY(width - 1, y)));
        }
    }

    private void spawnEntities(HashMap<String, Integer> entityMap) {
        try {
            for (String key : entityMap.keySet()) {
                for (int i = 0; i <= entityMap.get(key); i++) {

                    switch (key) {
                        case "GoodPlant":
                            setEntity(new GoodPlant(generateXY()));
                            break;
                        case "GoodBeast":
                            setEntity(new GoodBeast(generateXY()));
                            break;
                        case "BadBeast":
                            setEntity(new BadBeast(generateXY()));
                            break;
                        case "BadPlant":
                            setEntity(new BadPlant(generateXY()));
                            break;
                        default:
                            System.out.println("error in spawnEntities");
                    }
                }
            }
            setEntity(new HandOperatedMS(generateXY()));
        } catch (NullPointerException ignored) {
        }

    }


    public XY generateXY() {
        int x, y;
        boolean check = true;
        while (check) {
            x = (int) (Math.random() * config.getWidth());
            y = (int) (Math.random() * config.getHeight());
            XY newPos = new XY(x, y);
            if (posIsEmpty(newPos)) {
                check = false;
                return newPos;
            }
        }
        return null;
    }

    private void clearBoard() {
        for (int i = 0; i < entities.getEntitiesArr().length; i++) {
            entities.remove(entities.getEntitiesArr()[i]);
        }
    }

    public void updateGameBoard(Entity[] newEntities) {
        //this.clearBoard();
        for (int i = 0; i < newEntities.length; i++) {
            try {
                setEntity(newEntities[i]);
            } catch (NullPointerException ignored) {
            }
        }
    }

    public XY checkNearestPlayerEntity(XY pos, Entity e) {
        int x = pos.getX();
        int y = pos.getY();
        for (int i = 1; i < 7; i++) {
            for (int x_check = -i; x_check <= i; x_check++) {
                for (int y_check = -i; y_check <= i; y_check++) {
                    if (getEntity(new XY(x_check, y_check)) instanceof Squirrel) {
                        return new XY(x_check, y_check);
                    }
                }
            }
        }
        return null;
    }

    private boolean inRange(XY pos) {
        int x = pos.getX();
        int y = pos.getY();
        if (x < 0 || x >= config.getWidth()) {
            return false;
        }
        if (y < 0 || y >= config.getHeight()) {
            return false;
        }
        return true;
    }

    private boolean posIsEmpty(XY position) {
            if (entities.getEntity(position) != null) {
                return false;
            }
        return true;
    }

    public void flatten(EntitySet entities) {
        FlattenedBoard flattenedBoard = new FlattenedBoard(this, entities);
        toString(flattenedBoard.toStringArray());
    }

    private String toString(String[][] stringArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < config.getHeight(); y++) {
            for (int x = 0; x < config.getWidth(); x++) {
                stringBuilder.append(stringArr[x][y]);
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

}


