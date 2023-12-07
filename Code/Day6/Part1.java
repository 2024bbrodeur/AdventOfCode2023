package Code.Day6;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part1 {
    
    public static void main(String[] args) {
        int[][] inputPairs = getInput();
        int ans = productOfPossibleRecords(inputPairs);
        System.out.println(ans);
    }

    public static int productOfPossibleRecords(int[][] inputPairs) {
        int product = 1;
        for(int[] pair : inputPairs) {
            product *= possibleRecords(pair);
        }
        return product;
    }

    public static int possibleRecords(int[] pair) {
        int count = 0;
        for(int i = 0; i < pair[0]; i++) {
            if((pair[0]-i)*i>pair[1]) count++;
        }
        return count;
    }

    public static int[][] getInput() {
        ArrayList<String> lines = Input.getLines(new File("Code/Day6/input.txt"));
        ArrayList<String> times = Input.tokenize(lines.get(0), new String[] {" "});
        ArrayList<String> distances = Input.tokenize(lines.get(1), new String[] {" "});
        int[][] pairs = new int[times.size()-1][2];
        for(int i = 1; i < times.size(); i++) {
            pairs[i-1][0] = Integer.parseInt(times.get(i));
            pairs[i-1][1] = Integer.parseInt(distances.get(i));
        }
        return pairs;
    }

}
