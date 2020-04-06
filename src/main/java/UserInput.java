import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

    public UserInput() {
    }

    public String getUserInput(String promt) throws IOException {
        String userInput=null;
        System.out.println(promt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            userInput = is.readLine();
            if (userInput.length() == 0) return null;
        } catch (IIOException e) {
            System.out.println("IIOExeption: " + e);
        }
        return userInput;
    }
}
