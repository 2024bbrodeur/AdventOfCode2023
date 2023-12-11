package Code.Day8;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import Code.Input;

public class Part1 {
    
    public static void main(String[] args) {
        ArrayList<String> lines = Input.getLines(new File("Code/Day8/input.txt"));
        String directions = lines.get(0);
        HashMap<String, Node> nodes = getInput(lines);

        int steps = countSteps(nodes, directions);
        System.out.println(steps);
    }

    public static int countSteps(HashMap<String, Node> nodes, String directions) {
        int count = 0;
        String currNode = "AAA";
        while(!currNode.equals("ZZZ")) {
            
            if(directions.charAt(count % directions.length()) == 'L') {
                currNode = nodes.get(currNode).left;
            } else {
                currNode = nodes.get(currNode).right;
            }
            count++;
        }
        return count;
    }

    public static HashMap<String, Node> getInput(ArrayList<String> lines) {
        HashMap<String, Node> map = new HashMap<>();
        for(int i = 2; i < lines.size(); i++) {
            ArrayList<String> tokens = Input.tokenize(lines.get(i), new String[] {" ", "=", "(", ",", ")"});
            Node currNode = new Node(tokens.get(1), tokens.get(2));
            map.put(tokens.get(0), currNode);
        }
        return map;
    }

}
