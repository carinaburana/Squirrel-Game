package console;

import core.*;
import util.ui.console.Command;
import util.ui.console.CommandScanner;
import util.ui.console.CommandTypeInfo;
import util.ui.console.ScanException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ConsoleUI implements UI {

    private final PrintStream outputStream = System.out;
    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private CommandScanner commandScanner = new CommandScanner(GameCommandType.values(), inputReader, outputStream);

    @Override
    public void render(BoardView view) {

        for (int y = 0; y < view.getSize().getY(); y++) {
            for (int x = 0; x < view.getSize().getX(); x++) {
                System.out.print("|");
                Entity entity = view.getEntityType(x, y);

                if (entity instanceof Wall) {
                    System.out.print("WA");
                }
                else if (entity instanceof GoodPlant) {
                    System.out.print("GP");
                }
                else if (entity instanceof BadPlant) {
                    System.out.print("BP");
                }
                else if (entity instanceof GoodBeast) {
                    System.out.print("GB");
                }
                else if (entity instanceof BadBeast) {
                    System.out.print("BB");
                }
                else if (entity instanceof MasterSquirrel) {
                    System.out.print("SQ");
                }
                else if (entity instanceof MiniSquirrel) {
                    System.out.print("MQ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Command getCommand() {

        Command command = null;
        try {
            command = commandScanner.next();
        } catch (ScanException e) {
            System.out.println(e.getMessage());
        }

        return command;
    }

    @Override
    public void message(String message) {
        System.out.println(message);
    }

}
