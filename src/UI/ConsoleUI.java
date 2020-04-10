package UI;

import fatsquirrel.core.HandOperatedMS;
import fatsquirrel.core.XY;

import java.util.Scanner;

public class ConsoleUI implements UI{

    public ConsoleUI() { }

    public char move = 'x';

    public char readInput() {
        //reads from console
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("use w, a, s, d plus >enter< to move: ");
        String input = scanner.next();
        move = input.charAt(0);

        return move;
    }

    public boolean inputMakesSense(char input) {
        return input == 'w' || input == 'a' || input == 's' || input == 'd';
    }

    public XY nextStepHOMS(HandOperatedMS player){
        XY startPos = player.getXy();
        int x = startPos.getX();
        int y = startPos.getY();
        ConsoleUI inputReader = new ConsoleUI();

        char move;
        while (true) {
            move = readInput();
            boolean checker = inputMakesSense(move);
            if (checker) {
                break;
            }
            System.out.println("not w, a ,s ,d");
        }
        switch (move) {
            case 'w':
                y--;
                break;
            case 'a':
                x--;
                break;
            case 's':
                y++;
                break;
            case 'd':
                x++;
                break;
        }
        return new XY(x, y);
    }

    public MoveCommand getCommand() {
        return null;
    }


    public void render(BoardView view) {

    }
}
