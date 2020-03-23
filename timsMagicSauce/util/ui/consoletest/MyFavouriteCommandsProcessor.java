package util.ui.consoletest;

import util.ui.console.Command;
import util.ui.console.CommandScanner;
import util.ui.console.CommandTypeInfo;
import util.ui.console.ScanException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MyFavouriteCommandsProcessor {

    private final PrintStream outputStream = System.out;
    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private CommandScanner commandScanner = new CommandScanner(MyFavouriteCommandType.values(), inputReader, outputStream);


    public static void main(String[] args) {
        MyFavouriteCommandsProcessor processor = new MyFavouriteCommandsProcessor();
        processor.process();
    }


    public void process() {

        Command command = null;

        while (true) {

            try {
                command = commandScanner.next();
            } catch (ScanException e) {
                System.out.println(e.getMessage());
                continue;
            }

            Object[] params = command.getParams();
            MyFavouriteCommandType commandType = (MyFavouriteCommandType) command.getCommandType();

            switch (commandType) {
                case EXIT:
                    System.exit(0);
                case HELP:
                    help();
                    break;
                case ADDI:
                    addi(params[0], params[1]);
                    break;
                case ADDF:
                    addf(params[0], params[1]);
                    break;
                case ECHO:
                    echo(params[0], params[1]);
                    break;
            }
        }
    }

    private void echo(Object param1, Object param2) {
        for (int i = 0; i < (int) param2; i++) {
            System.out.println((String) param1);
        }
    }

    private void addf(Object param1, Object param2) {
        System.out.println((float) param1 + (float) param2);
    }

    private void addi(Object param1, Object param2) {
        System.out.println((int) param1 + (int) param2);
    }

    private void help() {
        CommandTypeInfo[] commandTypes = commandScanner.getCommandTypes();
        for (int i = 0; i < commandTypes.length; i++) {
            System.out.println(commandTypes[i].getName() + commandTypes[i].getHelpText());
        }
    }
}