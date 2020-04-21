package fatsquirrel.core;

public class EntitySet {
    private Entity[] e;

    public EntitySet(BoardConfig config) {

        e = new Entity[config.getHeight() * config.getWidth()];
    }

    public Entity[] getEntitiesArr() {
        return e;
    }

    public void add(Entity entity) {
        for (int i = 0; i < e.length; i++) {
            if (e[i] == null) {
                entity.setId(i);
                this.e[i] = entity;
                return;
            }
        }
    }


    public void remove(Entity e) {
        for (int i = 0; i < this.e.length; i++) {
            try {
                if (e.equals(this.e[i])) {
                    this.e[i] = null;
                    return;
                }
            } catch (NullPointerException ignored) {
            }
        }
    }

    public Entity getEntity(XY pos) {
        for (int i = 0; i < e.length; i++) {
            if (e[i] != null) {
                if (e[i].getXy().equals(pos))
                    return e[i];
            }
        }
        return null;
    }

    public void nextStep(Board board) {
        try {
            for (int i = 0; i < e.length; i++) {
                Entity e = this.e[i];
                e.nextStep();
            }
        } catch (NullPointerException ignored) {
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        try {
            for (Entity e : e) {
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
