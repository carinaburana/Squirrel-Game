package core;

import java.util.ArrayList;


public class EntitySet {

    private ArrayList<Entity> entities;

    public EntitySet() { entities = new ArrayList<>(); }

    public void insert(Entity e) {
        entities.add(e);
    }

    public void remove(Entity e) {
        entities.remove(e);
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) != null) {
                s += entities.get(i).toString() + '\n';
            }
        }
        return s;
    }

    public void nextStep(State state) {
        for (Entity entity : entities) {
            if (entity instanceof Character) {
                ((Character) entity).nextStep(state.flattenedBoard());
            }
        }
    }


    public boolean isValidPosition(XY xy) {
        for (Entity e : entities) {
            if (xy.equals(e.getPosition())) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
