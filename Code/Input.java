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

    public static ArrayList<String> tokenize(String input, String[] splitPoints) {
        ArrayList<String> tokens = new ArrayList<>();
        int lastSplitPoint = 0;

        for(int i = 0; i < input.length(); i++) {
            for(String splitPoint : splitPoints) {
                if(input.substring(i, splitPoint.length() + i).equals(splitPoint)) {
                    if(i != lastSplitPoint) {
                        tokens.add(input.substring(lastSplitPoint, i));
                    }
                    lastSplitPoint = i+1;
                }
            }
            if(i == input.length()-1) {
                if(i != lastSplitPoint-1) {
                    tokens.add(input.substring(lastSplitPoint));
                }
            }
        }

        return tokens;
    }

}
