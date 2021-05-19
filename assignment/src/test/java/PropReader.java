

import java.io.*;
import java.util.Properties;

public class PropReader {
    private static PropReader instance = null;
    static Properties prop = null;
    static FileInputStream in = null;
    private PropReader() {

        try {
            in = new FileInputStream("C:\\Users\\praveenkumar\\IdeaProjects\\assignment-2\\assignment\\src\\test\\java\\repository.properties");
            prop = new Properties();
            prop.load(in);

        }
        catch (Exception e) {

            System.out.println(e);
        }
    }
    public static PropReader getInstance() throws IOException {

        if (instance == null) {
            instance = new PropReader();
        }

        return instance;
    }


}
