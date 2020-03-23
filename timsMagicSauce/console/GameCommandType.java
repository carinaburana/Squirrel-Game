package console;

import util.ui.console.CommandTypeInfo;

public enum GameCommandType implements CommandTypeInfo {

    HELP("help", "  * list all commands"),
    EXIT("exit", "  * exit program"),
    ALL("all", " ??? "),
    LEFT("left", "  * moves the squirrel to the left"),
    RIGHT("right", "  * moves the squirrel to the right"),
    UP("up", "  * moves the squirrel up"),
    DOWN("down", "  * moves the squirrel down"),
    MASTER_ENERGY("master_energy", "  * shows energy of the master squirrel"),
    SPAWN_MINI("spawn_mini", "<param1>  * spawns a mini squirrel with a starting energy", int.class);

    private final String commandName;
    private final String helpText;
    private final Class[] params;

    GameCommandType(String commandName, String helpText, Class param1) {
        this.commandName = commandName;
        this.helpText = helpText;
        this.params = new Class[]{param1};
    }

    GameCommandType(String commandName, String helpText) {
        this.commandName = commandName;
        this.helpText = helpText;
        this.params = new Class[0];
    }

    @Override
    public String getName() {
        return commandName;
    }

    @Override
    public String getHelpText() {
        return helpText;
    }

    @Override
    public Class<?>[] getParamTypes() {
        return params;
    }
}