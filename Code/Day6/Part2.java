package Code.Day6;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part2 {
    
    public static void main(String[] args) {
        long[] pair = getInput();
        System.out.println(possibleRecords(pair));
    }

    public static long possibleRecords(long[] pair) {
        long count = 0;
        for(int i = 0; i < pair[0]; i++) {
            if((pair[0]-i)*i>pair[1]) count++;
        }
        return count;
    }

    public static long[] getInput() {
        ArrayList<String> lines = Input.getLines(new File("Code/Day6/input.txt"));
        String time = "";
        String dist = "";

        for(int i = 0; i < lines.get(0).length(); i++) {
            char curr = lines.get(0).charAt(i);
            if(isDigit(curr)) time += curr;
        }

        for(int i = 0; i < lines.get(0).length(); i++) {
            char curr = lines.get(1).charAt(i);
            if(isDigit(curr)) dist += curr;
        }

        return new long[]{Long.parseLong(time), Long.parseLong(dist)};
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

}
