package Code.Day2;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part2 {
    
    public static void main(String[] args) {
        ArrayList<String> lines = Input.getLines(new File("Code/Day2/input.txt"));
        ArrayList<Game> games = Part1.createGames(lines);
        int result = playGame(games);
        System.out.println(result);
    }

    public static int playGame(ArrayList<Game> games) {
        int ans = 0;
        for(Game game : games) {
            ans += getPowerSet(game);
        }
        return ans;
    }

    public static int getPowerSet(Game game) {
        int r = 0;
        int g = 0;
        int b = 0;
        for(Integer[] round : game.rounds) {
            r = Math.max(r, round[0]);
            g = Math.max(g, round[1]);
            b = Math.max(b, round[2]);
        }

        return r * g * b;
    }

}
