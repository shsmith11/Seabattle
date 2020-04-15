import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;


public class UserInput {

    private int size;
    private String coord;




    public int setSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter field size");
        while (!scanner.hasNext(Pattern.compile("[8]*[10]*"))) {
            System.out.println("Это все хуйня, попробуй еще!  " + scanner.next());
        }
        // print the rest of the string
        System.out.println("Good Choice Captain !");
        this.size = scanner.nextInt();
        // close the scanner
        scanner.close();

        return this.size;
    }

    public String setCoord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set coordinates to strike enemy fleet, Captain");
        while (!scanner.hasNext(Pattern.compile("[a-j1-9]*[10]*"))) {
            // add check for Length
            System.out.println("Это все хуйня, попробуй еще!  " + scanner.next());
        }
        // print the rest of the string
        System.out.println("Good Choice, Captain!");
        this.size = scanner.nextInt();
        // close the scanner
        scanner.close();

        return this.coord;
    }
}
