package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private EntitySet entities;
    private List<Entity> entitiesToAdd = new ArrayList<>();
    private List<Entity> entitiesToDelete = new ArrayList<>();
    private BoardConfig config;


    public Board(BoardConfig config) {
        this.config = config;
        entities = new EntitySet();
        init();
    }

    private void init() {
        createWalls(config.getWidth(), config.getHeight());
        spawnEntitiesRandomly(config.getEntityMap(), config.getWidth(), config.getHeight());
    }

    public FlattenedBoard flatten() {
        return new FlattenedBoard(this);
    }

    public void update(State state) {
        entities.nextStep(state);
        for (Entity e : entitiesToAdd) {
            entities.insert(e);
        }
        for (Entity e : entitiesToDelete) {
            entities.remove(e);
        }
        entitiesToAdd.clear();
        entitiesToDelete.clear();
    }

    private void spawnEntitiesRandomly(HashMap<String, Integer> entityMap, int width, int height) {
        for (String key : entityMap.keySet()) {
            for (int i = 0; i < entityMap.get(key); i++) {

                XY randomPosition;
                do {
                    randomPosition = new XY((int) (Math.random() * (width - 2)) + 1,
                            (int) (Math.random() * (height - 2)) + 1);
                } while (!entities.isValidPosition(randomPosition));

                switch (key) {
                    case "de.hsa.games.fatsquirrel.core.GoodPlant":
                        entities.insert(new GoodPlant(0, randomPosition));
                        break;
                    case "de.hsa.games.fatsquirrel.core.BadPlant":
                        entities.insert(new BadPlant(0, randomPosition));
                        break;
                    case "de.hsa.games.fatsquirrel.core.Wall":
                        entities.insert(new Wall(0, randomPosition));
                        break;
                    case "de.hsa.games.fatsquirrel.core.GoodBeast":
                        entities.insert(new GoodBeast(0, randomPosition));
                        break;
                    case "de.hsa.games.fatsquirrel.core.BadBeast":
                        entities.insert(new BadBeast(0, randomPosition));
                        break;
                    case "de.hsa.games.fatsquirrel.core.HandOperatedMS":
                        entities.insert(new HandOperatedMasterSquirrel(0, randomPosition));
                        break;
                    default:
                        System.err.println(key);
                }
            }
        }
    }

    private void createWalls(int width, int height) {
        // horizontal walls
        for (int x = 0; x < width; x++) {
            entities.insert(new Wall(0, new XY(x, 0)));
            entities.insert(new Wall(0, new XY(x, height - 1)));
        }

        // vertical walls
        for (int y = 1; y < height - 1; y++) {
            entities.insert(new Wall(0, new XY(0, y)));
            entities.insert(new Wall(0, new XY(width - 1, y)));
        }
    }


    public EntitySet getEntitySet() {
        return entities;
    }

    public int getWidth() {
        return config.getWidth();
    }

    public int getHeight() {
        return config.getHeight();
    }

    public List<Entity> getEntitiesToAdd() {
        return entitiesToAdd;
    }

    public List<Entity> getEntitiesToDelete() {
        return entitiesToDelete;
    }

}
