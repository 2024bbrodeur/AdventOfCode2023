package Code;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    
    public static ArrayList<String> getLines(File file) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            Scanner s = new Scanner(file);
            while(s.hasNextLine()) {
                lines.add(s.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Did not read input");
            System.out.println(e);
        }

        return lines;
    }

}
