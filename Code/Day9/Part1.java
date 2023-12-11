package Code.Day9;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part1 {
    
    public static void main(String[] args) {
        ArrayList<String> lines = Input.getLines(new File("Code/Day9/input.txt"));

        int sumOfExtrapolation = getSumOfExtrapolation(lines);
        System.out.println(sumOfExtrapolation);
    }

    public static int getSumOfExtrapolation(ArrayList<String> lines) {
        int sum = 0;
        for(String line : lines) {
            System.out.println(extrapolate(line));
            sum += extrapolate(line);
        }
        return sum;
    }

    public static int extrapolate(String line) {
        ArrayList<String> tokensString = Input.tokenize(line, new String[] {" "});
        ArrayList<Integer> tokens = new ArrayList<>();
        for(String token : tokensString) {
            tokens.add(Integer.parseInt(token));
        }
        ArrayList<ArrayList<Integer>> differencesMap = new ArrayList<>();
        differencesMap.add(tokens);

        boolean allZero = false;
        while(!allZero) {
            allZero = true;
            ArrayList<Integer> lastDiff = differencesMap.get(differencesMap.size()-1);
            ArrayList<Integer> differences = new ArrayList<>();
            for(int i = 0; i < lastDiff.size()-1; i++) {
                int diff = lastDiff.get(i+1) - lastDiff.get(i);
                differences.add(diff);
                if(diff != 0) allZero = false;
            }
            differencesMap.add(differences);
        }

        differencesMap.get(differencesMap.size()-1).add(0);

        for(int i = differencesMap.size()-2; i >= 0; i--) {
            ArrayList<Integer> curr = differencesMap.get(i);
            ArrayList<Integer> last = differencesMap.get(i+1);
            int next = curr.get(curr.size()-1)
            + last.get(last.size()-1);

            curr.add(next);
        }

        // for(int i = 0; i < differencesMap.size(); i++) {
        //     for(int j = 0; j < differencesMap.get(i).size(); j++) {
        //         System.out.print(differencesMap.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }

        return differencesMap.get(0).get(differencesMap.get(0).size()-1);

    }

}
