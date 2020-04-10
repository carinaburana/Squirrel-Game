package core;

import java.util.HashMap;

public class BoardConfig {

    private final int width;
    private final int height;
    private HashMap<String, Integer> entityMap;

    public BoardConfig() {
        width = 10;
        height = 10;
        entityMap = new HashMap<>();
        entityMap.put("de.hsa.games.fatsquirrel.core.GoodPlant", 1);
        // entityMap.put("de.hsa.games.fatsquirrel.core.HandOperatedMS", 1);
        entityMap.put("de.hsa.games.fatsquirrel.core.BadPlant", 3);
        entityMap.put("de.hsa.games.fatsquirrel.core.BadBeast", 1);
        entityMap.put("de.hsa.games.fatsquirrel.core.GoodBeast", 2);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public HashMap<String, Integer> getEntityMap() {
        return entityMap;
    }
}
