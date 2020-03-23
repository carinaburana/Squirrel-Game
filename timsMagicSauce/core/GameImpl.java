package core;

import console.GameCommandType;
import console.UI;
import util.ui.console.Command;
import util.ui.console.CommandTypeInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GameImpl extends Game {

    HandOperatedMasterSquirrel player;

    public GameImpl(State state, UI ui, HandOperatedMasterSquirrel player) {
        super(state, ui);
        this.player = player;

    }

    @Override
    protected void render() {
        ui.render(state.flattenedBoard());
    }

    @Override
    protected void processInput() {
        Command command = ui.getCommand();

        Object[] params = command.getParams();
        GameCommandType commandType = (GameCommandType) command.getCommandType();

        try {

            Class clazz = Class.forName("core.GameImpl");
            Method method = clazz.getDeclaredMethod(commandType.getName(), commandType.getParamTypes());
            method.invoke(this, params);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//
//        switch (commandType) {
//            case EXIT:
//                System.exit(0);
//            case HELP:
//                ui.help();
//                break;
//            case ALL:
//                // TO DO
//                break;
//            case LEFT:
//                player.setMoveCommand(new XY(-1, 0));
//                break;
//            case RIGHT:
//                player.setMoveCommand(new XY(1, 0));
//                break;
//            case UP:
//                player.setMoveCommand(new XY(0, -1));
//                break;
//            case DOWN:
//                player.setMoveCommand(new XY(0, 1));
//                break;
//            case MASTER_ENERGY:
//                ui.outputEnergy(player.getEnergy());
//                break;
//            case SPAWN_MINI:
//                try {
//                    state.flattenedBoard().spawnMiniSquirrel(player, (int) params[0]);
//                } catch (NotEnoughEnergyException e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//        }
    }

    private void exit() {
        System.exit(0);
    }

    private void help() {
        CommandTypeInfo[] commandTypes = GameCommandType.values();
        String message = "";
        for (int i = 0; i < commandTypes.length; i++) {
            message += commandTypes[i].getName() + commandTypes[i].getHelpText() + '\n';
        }
        ui.message(message);
    }

    private void all() {

    }

    private void left() {
        player.setMoveCommand(new XY(-1, 0));
    }

    private void right() {
        player.setMoveCommand(new XY(1, 0));
    }

    private void up() {
        player.setMoveCommand(new XY(0, -1));
    }

    private void down() {
        player.setMoveCommand(new XY(0, 1));
    }

    private void master_energy() {
        ui.message("Your current energy: " + player.getEnergy());
    }

    private void spawn_mini(int energy) {
        try {
            state.flattenedBoard().spawnMiniSquirrel(player, energy);
        } catch (NotEnoughEnergyException e) {
            ui.message(e.getMessage());
        }
    }
}


