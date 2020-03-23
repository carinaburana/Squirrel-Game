import java.util.Scanner;

public class ConsoleIO {

    public char getInput(){
        //reads from console
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("press w,a,s,d : " );
        String input = scanner.next();
        char move = input.charAt(0);

        return move;


}}
