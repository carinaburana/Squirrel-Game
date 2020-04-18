package fatsquirrel.core;

import java.util.HashMap;

public class BoardConfig {

    private final int height;
    private final int width;
    private HashMap<String, Integer> entityMap = new HashMap<String, Integer>();
    private int wallCount;

    public BoardConfig() {
        height = 10;
        width = 10;
        entityMap.put("GoodPlant", 4);
        entityMap.put("BadPlant", 4);
        entityMap.put("GoodBeast", 2);
        entityMap.put("BadBeast", 2);
        entityMap.put("MasterSquirrel", 1);
        entityMap.put("MiniSquirrel", 1);
        entityMap.put("HOMS", 1);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public HashMap<String, Integer> getEntityMap() {
        return entityMap;
    }

}
