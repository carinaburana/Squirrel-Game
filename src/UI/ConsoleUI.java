package UI;

import fatsquirrel.core.HandOperatedMS;
import fatsquirrel.core.XY;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements UI {

    public String move = "xx";

    public String readInput() {
        //reads from console
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("use w, a, s, d plus >enter< to move: ");
        String input = scanner.next();
        return input;
    }

    public XY nextStepVectorHOMS() {
        int x = 0;
        int y = 0;
        boolean checker = true;
        try {
            while (checker) {
                move = readInput();
                    switch (move) {
                        case "w":
                            y--;
                            checker = false;
                            break;
                        case "a":
                            x--;
                            checker = false;
                            break;
                        case "s":
                            y++;
                            checker = false;
                            break;
                        case "d":
                            x++;
                            checker = false;
                            break;
                        case "wd":
                        case "dw":
                            x++;
                            y--;
                            checker = false;
                            break;
                        case "ds":
                        case "sd":
                            x++;
                            y++;
                            checker = false;
                            break;
                        case "as":
                        case "sa":
                            x--;
                            y++;
                            checker = false;
                            break;
                        case "aw":
                        case "wa":
                            x--;
                            y--;
                            checker = false;
                            break;
                        default:
                            System.out.println("no correct input");
                    }
                }
        } catch (InputMismatchException b) {
            System.out.println("invalid input");
        }
        return new XY(x, y);
    }


    public MoveCommand getCommand() {
        return null;
    }


    public void render(BoardView view) {

    }
}
