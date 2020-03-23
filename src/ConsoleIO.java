import java.util.Scanner;

public class ConsoleIO {

    private char move = 'x';

    public char readInput(){
        //reads from console

        while(move !='w' || move !='a' || move !='s' || move != 'd'){
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.print("use w, a, s, d plus >enter< to move: ");
            String input = scanner.next();
            move = input.charAt(0);
        }
        return move;


}


}
