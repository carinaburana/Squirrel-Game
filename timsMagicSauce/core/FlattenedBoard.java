package core;

import java.util.ArrayList;
import java.util.Random;

public class FlattenedBoard implements BoardView, EntityContext {

    private Board board;
    private Entity[][] field;

    public FlattenedBoard(Board board) {
        field = new Entity[board.getWidth()][board.getHeight()];
        for (Entity e : board.getEntitySet().getEntities()) {
            field[e.getPosition().getX()][e.getPosition().getY()] = e;
        }
        this.board = board;
    }

    @Override
    public XY getSize() {
        return new XY(field.length, field[0].length);
    }

    @Override
    public void tryMove(MasterSquirrel masterSquirrel, XY moveDirection) {
        Entity entity = field[masterSquirrel.getPosition().getX() + moveDirection.getX()]
                             [masterSquirrel.getPosition().getY() + moveDirection.getY()];

        if (entity instanceof Wall) {
            masterSquirrel.updateEnergy(entity.getEnergy());
            masterSquirrel.paralyze();
        }
        else if (entity instanceof GoodPlant) {
            masterSquirrel.updateEnergy(entity.getEnergy());
            killAndReplace(entity);
            move(masterSquirrel, moveDirection);
        }
        else if (entity instanceof BadPlant) {
            masterSquirrel.updateEnergy(entity.getEnergy());
            killAndReplace(entity);
            move(masterSquirrel, moveDirection);
        }
        else if (entity instanceof GoodBeast) {
            masterSquirrel.updateEnergy(entity.getEnergy());
            killAndReplace(entity);
            move(masterSquirrel, moveDirection);
        }

        else if (entity instanceof BadBeast) {
            masterSquirrel.updateEnergy(entity.getEnergy());
            ((BadBeast) entity).reduceBites();
        }

        else if (entity instanceof MiniSquirrel) {
            if (masterSquirrel == ((MiniSquirrel) entity).getPatron()) {
                masterSquirrel.updateEnergy(entity.getEnergy());
            }
            else {
                masterSquirrel.updateEnergy(150);
            }
            kill(entity);
            move(masterSquirrel, moveDirection);
        }

        else if (entity == null) {
            move(masterSquirrel, moveDirection);
        }

    }

    @Override
    public void tryMove(MiniSquirrel miniSquirrel, XY moveDirection) {
        if (miniSquirrel.getEnergy() <= 0) {
            kill(miniSquirrel);
            return;
        }

        Entity entity = field[miniSquirrel.getPosition().getX() + moveDirection.getX()]
                [miniSquirrel.getPosition().getY() + moveDirection.getY()];

        if (entity instanceof Wall) {
            miniSquirrel.updateEnergy(entity.getEnergy());
            miniSquirrel.paralyze();
        }

        else if (entity instanceof GoodPlant) {
            miniSquirrel.updateEnergy(entity.getEnergy());
            killAndReplace(entity);
            move(miniSquirrel, moveDirection);
        }

        else if (entity instanceof BadPlant) {
            miniSquirrel.updateEnergy(entity.getEnergy());
            killAndReplace(entity);
            move(miniSquirrel, moveDirection);
        }

        else if (entity instanceof GoodBeast) {
            miniSquirrel.updateEnergy(entity.getEnergy());
            killAndReplace(entity);
            move(miniSquirrel, moveDirection);
        }

        else if (entity instanceof BadBeast) {
            miniSquirrel.updateEnergy(entity.getEnergy());
            ((BadBeast) entity).reduceBites();
        }

        else if (entity instanceof MasterSquirrel) {
            if (miniSquirrel.getPatron().equals(entity)) {
                entity.updateEnergy(miniSquirrel.getEnergy());
            }
            kill(miniSquirrel);
        }

        else if (entity instanceof MiniSquirrel) {
            if (!miniSquirrel.getPatron().equals(((MiniSquirrel) entity).getPatron())) {
                kill(miniSquirrel);
                kill(entity);
            }
        }

        else if (entity == null) {
            move(miniSquirrel, moveDirection);
        }
    }

    @Override
    public void tryMove(GoodBeast goodBeast, XY moveDirection) {
        goodBeast.updateWaitTime();
        Squirrel nearestSquirrel = nearestPlayerEntity(goodBeast.getPosition());
        if (nearestSquirrel != null) {
            if (nearestSquirrel.getPosition().getX() < goodBeast.getPosition().getX()) {
                moveDirection = new XY(1, moveDirection.getY());
            }
            else if (nearestSquirrel.getPosition().getX() > goodBeast.getPosition().getX()) {
                moveDirection = new XY(-1, moveDirection.getY());
            }
            else if (nearestSquirrel.getPosition().getY() < goodBeast.getPosition().getY()) {
                moveDirection = new XY(moveDirection.getX(), 1);
            }
            else if (nearestSquirrel.getPosition().getY() > goodBeast.getPosition().getY()) {
                moveDirection = new XY(moveDirection.getX(), -1);
            }
        }
        if (field[goodBeast.getPosition().getX() + moveDirection.getX()]
                 [goodBeast.getPosition().getY() + moveDirection.getY()] == null) {
            move(goodBeast, moveDirection);
        }

    }

    @Override
    public void tryMove(BadBeast badBeast, XY moveDirection) {
        badBeast.updateWaitTime();
        if (badBeast.getRemainingBites() == 0) {
            killAndReplace(badBeast);
            return;
        }

        Squirrel nearestSquirrel = nearestPlayerEntity(badBeast.getPosition());
        if (nearestSquirrel != null) {
            if (nearestSquirrel.getPosition().getX() < badBeast.getPosition().getX()) {
                moveDirection = new XY(-1, moveDirection.getY());
            }
            else if (nearestSquirrel.getPosition().getX() > badBeast.getPosition().getX()) {
                moveDirection = new XY(1, moveDirection.getY());
            }
            else if (nearestSquirrel.getPosition().getX() == badBeast.getPosition().getX()) {
                moveDirection = new XY(0, moveDirection.getY());
            }

            else if (nearestSquirrel.getPosition().getY() < badBeast.getPosition().getY()) {
                moveDirection = new XY(moveDirection.getX(), -1);
            }
            else if (nearestSquirrel.getPosition().getY() > badBeast.getPosition().getY()) {
                moveDirection = new XY(moveDirection.getX(), 1);
            }
            else if (nearestSquirrel.getPosition().getY() == badBeast.getPosition().getY()) {
                moveDirection = new XY(moveDirection.getX(), 0);
            }
        }
        Entity entity = field[badBeast.getPosition().getX() + moveDirection.getX()]
                [badBeast.getPosition().getY() + moveDirection.getY()];

        if (entity instanceof MiniSquirrel) {
            entity.updateEnergy(badBeast.getEnergy());
            badBeast.reduceBites();
        }
        else if (entity instanceof MasterSquirrel) {
            entity.updateEnergy(badBeast.getEnergy());
            badBeast.reduceBites();
        }
        else if (entity == null) {
            move(badBeast, moveDirection);
        }

    }

    @Override
    public void killAndReplace(Entity entity) {
        kill(entity);
        XY position = getValidPosition();
        Entity newEntity = null;

        if (entity instanceof GoodPlant) {
            newEntity = new GoodPlant(0, position);
        }
        else if (entity instanceof BadPlant) {
            newEntity = new BadPlant(0, position);
        }
        else if (entity instanceof GoodBeast) {
            newEntity = new GoodBeast(0, position);
        }
        else if (entity instanceof BadBeast) {
            newEntity = new BadBeast(0, position);
        }

        board.getEntitiesToAdd().add(newEntity);
        field[position.getX()][position.getY()] = newEntity;
    }

    @Override
    public void kill(Entity entity) {
        board.getEntitiesToDelete().add(entity);
        field[entity.getPosition().getX()][entity.getPosition().getY()] = null;
    }

    @Override
    public Squirrel nearestPlayerEntity(XY position) {
        int radius = 6;
        ArrayList<Squirrel> nearestPlayers = new ArrayList<>();
        for (int x = position.getX() - radius; x < position.getX() + radius; x++) {
            for (int y = position.getY() - radius; y < position.getY() + radius; y++) {
                try {
                    if (field[x][y] instanceof Squirrel) {
                        nearestPlayers.add((Squirrel) field[x][y]);
                    }
                } catch (Exception e) {
                    // TODO
                }
            }
        }
        if (nearestPlayers.size() > 0) {
            Random random = new Random();
            return nearestPlayers.get(random.nextInt(nearestPlayers.size()));
        }
        return null;
    }

    private XY getValidPosition() {
        XY randomPosition;
        do {
            randomPosition = new XY((int) (Math.random() * (field.length - 2)) + 1,
                    (int) (Math.random() * (field[0].length - 2)) + 1);
        } while (field[randomPosition.getX()][randomPosition.getY()] != null);
        return randomPosition;
    }

    public Entity getEntityType(int x, int y) {
        return field[x][y];
    }

    public void move(Entity entity, XY moveCommand) {
        field[entity.getPosition().getX()][entity.getPosition().getY()] = null;
        entity.setPosition(entity.getPosition().add(moveCommand));
        field[entity.getPosition().getX()][entity.getPosition().getY()] = entity;
    }

    public void spawnMiniSquirrel(MasterSquirrel patron, int energy) throws NotEnoughEnergyException {

        if (patron.getEnergy() - energy <= 0) throw new NotEnoughEnergyException("Squirrel doesn't have enough energy.");


        // find a valid position around the mastersquirrel
        XY position = null;
        for (int i = - 1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (field[patron.getPosition().getX() + i][patron.getPosition().getY() + j] == null) {
                    position = new XY(patron.getPosition().getX() + i, patron.getPosition().getY() + j);
                    break;
                }
            }
        }

        patron.updateEnergy(energy * -1);
        MiniSquirrel newEntity = new MiniSquirrel(0, energy, position, patron);

        board.getEntitiesToAdd().add(newEntity);
        field[position.getX()][position.getY()] = newEntity;
    }
}
