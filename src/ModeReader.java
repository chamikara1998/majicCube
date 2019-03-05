import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This Class for Read Values from User
 */
public class ModeReader {

    /**
     * Read Mode From User
     * @return
     */
    public int read(){
        int mode = -1;
        String readValue = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter \"s\" to start Magic Cube and \"q\" to Exit.");
        System.out.print("> ");
        try {
            readValue = br.readLine().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (readValue.equals("s")){
            mode = 0;
        }else if (readValue.equals("q")) {
            mode = 1;
        }
        return mode;
    }
}
