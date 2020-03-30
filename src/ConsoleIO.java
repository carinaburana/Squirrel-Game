import java.util.Scanner;

public class ConsoleIO {

    public ConsoleIO() {
    }

    public char move = 'x';

    public char readInput() {
        //reads from console

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("use w, a, s, d plus >enter< to move: ");
        String input = scanner.next();
        move = input.charAt(0);
        System.out.println("i got " + move);

        return move;


    }

    public boolean inputMakesSense(char input) {


        if (input == 'w' || input == 'a' || input == 's' || input == 'd') {
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    }


}
