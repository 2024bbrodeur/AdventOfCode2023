package Code.Day8;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import Code.Input;

public class Part2 {
    
    public static void main(String[] args) {
        ArrayList<String> lines = Input.getLines(new File("Code/Day8/input.txt"));
        String directions = lines.get(0);
        HashMap<String, Node> nodes = Part1.getInput(lines);

        long steps = countSteps(nodes, directions);
        System.out.println(steps);
    }

    public static long countSteps(HashMap<String, Node> nodes, String directions) {
        ArrayList<String> currNodes = new ArrayList<>();
        for(String key : nodes.keySet()) {
            if(key.charAt(2) == 'A') {
                currNodes.add(key);
            }
        }

        ArrayList<Integer> steps = new ArrayList<>();

        for(int i = 0; i < currNodes.size(); i++) {
            int count = 0;
            String currNode = currNodes.get(i);

            while(currNode.charAt(2) != 'Z') {
                if(directions.charAt(count % directions.length()) == 'L') {
                    currNode = nodes.get(currNode).left;
                } else {
                    currNode = nodes.get(currNode).right;
                }
                count++;
            }
            steps.add(count);
        }

        long lcm = getLeastMutliple(steps.get(0), steps.get(1));

        for(int i = 2; i < steps.size(); i++) {
            lcm = getLeastMutliple(lcm, steps.get(i));
        }

        return lcm;
    }

    public static long getLeastMutliple(long num1, long num2) {
        long count1 = 1;
        long count2 = 1;

        while(num1 * count1 != num2 * count2) {
            if(num1*count1 > num2*count2) count2++;
            else count1++;
        }

        return num1*count1;
    }

}
