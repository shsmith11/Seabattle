import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    private String name;
    private Integer score;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName() {
        //String nameInputTry = null;
        boolean tryInput=false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name, Captain");
        while (!tryInput) {
            tryInput = scanner.hasNext(Pattern.compile("[A-Za-z0-9]*"));
            if (!tryInput) System.out.println("Enter again!");
            this.name = scanner.next();
        }
        System.out.println("Good day, Captain " + this.name);
        System.out.println("");
        //scanner.close();
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
