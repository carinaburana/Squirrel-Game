package fatsquirrel.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    BoardConfig config;
    EntitySet entities;


    public Board(BoardConfig config) {
        this.config = config;
        entities = new EntitySet(config.getHeight() * config.getWidth());
        start();
    }

    public void start() {
        spawnEntities(config.getEntityMap());
        drawWalls(config.getHeight(), config.getWidth());
    }

    public void drawWalls(int height, int width) {
        //walls horizontal
        for (int x = 0; x < width; x++) {
            entities.add(new Wall(new XY(x, 0), entities.generateId()));
            entities.add(new Wall(new XY(x, height - 1), entities.generateId()));
        }
        //walls vertical
        for (int y = 1; y < height - 1; y++) {
            entities.add(new Wall(new XY(0, y), entities.generateId()));
            entities.add(new Wall(new XY(width - 1, y), entities.generateId()));
        }
        updateGameBoard(entities.getEntitiesArr());
    }

    public void spawnEntities(HashMap<String, Integer> entityMap) {

        entities.add(new HandOperatedMS(generateXY(), entities.generateId()));

        for (String key : entityMap.keySet()) {
            for (int i = 0; i <= entityMap.get(key); i++) {

                switch (key) {
                    case "GoodPlant":
                        entities.add(new GoodPlant(generateXY(), entities.generateId()));
                        break;
                    case "GoodBeast":
                        entities.add(new GoodBeast(generateXY(), entities.generateId()));
                        break;
                    case "BadBeast":
                        entities.add(new BadBeast(generateXY(), entities.generateId()));
                        break;
                    case "BadPlant":
                        entities.add(new BadPlant(generateXY(), entities.generateId()));
                        break;
                    default:
                        System.out.println("error in spawnEntities");
                }
            }
        }
    }

    public Entity [][] board(EntitySet entities){
        Entity[][] board = new Entity[config.getWidth()][config.getHeight()];
        Entity [] array = entities.getEntitiesArr();
        for(int i = 0; i<array.length; i++){
            try {
               board[array[i].getXy().getX()][array[i].getXy().getY()] = array[i];
            }catch (NullPointerException ignored){}
        }
        return board;
    }

    public int generateId(EntitySet entitySet) {
        int id;
        for (id = 0; id < entitySet.getEntitiesArr().length; id++) {
            try {
                if (entitySet.getEntitiesArr()[id] == null)
                    return id;
            } catch (NullPointerException e) {
                return id;
            }
        }
        return id;
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

    public int getHeight() {
        return config.getHeight();
    }

    public EntitySet getEntitySet() {
        return entities;
    }

    public int getWidth() {
        return config.getWidth();
    }

    public Entity getEntity(XY pos) {
        return entities.getEntity(pos);
    }

    public void clearBoard() {
        for (int i = 0; i < entities.getEntitiesArr().length; i++) {
            entities.remove(entities.getEntitiesArr()[i]);
        }
    }

    public void updateGameBoard(Entity[] allEntitiesOnField) {
        this.clearBoard();
        for (Entity e : allEntitiesOnField) {
            try {
                setEntity(e);
            } catch (NullPointerException ignored) {
            }
        }
    }

    public void setEntity(Entity e) {
        XY pos = e.getXy();
        if (inRange(pos)) {
            if (posIsEmpty(pos)) {
                entities.add(e);
            }
            //collision
            else {
            }
        }
    }

    public boolean inRange(XY pos) {
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

    public boolean posIsEmpty(XY position) {
        try {
            if (entities.getEntity(position) != null) {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("out of bound");
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }

    public String[][] flatten() {
        String[][] flattenedBoard = new String[config.getWidth()][config.getHeight()];
        for (int i = 0; i < entities.getEntitiesArr().length; i++) {
            try {
                if (entities.getEntitiesArr()[i] != null) {
                    XY pos = entities.getEntitiesArr()[i].getXy();
                    flattenedBoard[pos.getX()][pos.getY()] = ("|" + entities.getEntitiesArr()[i].getType() + "|");
                }
            } catch (NullPointerException n) {
                XY pos = entities.getEntitiesArr()[i].getXy();
                flattenedBoard[pos.getX()][pos.getY()] = ("|  |");
            }
        }
        return flattenedBoard;
    }


        public String toString(String[][] stringArr) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int y = 0; y < config.getHeight(); y++) {
                for (int x = 0; x < config.getWidth(); x++) {
                        stringBuilder.append(stringArr[x][y]);
                }
                stringBuilder.append('\n');
            }
            return stringBuilder.toString();
        }
    }


