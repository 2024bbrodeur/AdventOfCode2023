package Code.Day2;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part1 {
    
    public static void main(String[] args) {
        ArrayList<String> lines = Input.getLines(new File("Code/Day2/input.txt"));
        ArrayList<Game> games = createGames(lines);
        int result = playGame(games, 12, 13, 14);
        System.out.println(result);
    }

    public static int playGame(ArrayList<Game> games, int r, int g, int b) {
        int ans = 0;
        for(Game game : games) {
            if(isPossible(game, r, g, b)) {
                ans += game.id;
            }
        }
        return ans;
    }

    public static boolean isPossible(Game game, int r, int g, int b) {
        for(Integer[] round : game.rounds) {
            if(round[0] > r || round[1] > g || round[2] > b) return false;
        }
        return true;
    }

    public static ArrayList<Game> createGames(ArrayList<String> lines) {
        ArrayList<Game> games = new ArrayList<>();
        for(String line : lines) {
            games.add(createGame(line));
        }
        return games;
    }

    public static Game createGame(String line) {
        ArrayList<Integer[]> rounds = new ArrayList<>();
        ArrayList<String> tokens = Input.tokenize(line, new String[] {";", ":"});

        int id = Integer.parseInt(tokens.get(0).substring(5));
        for(int i = 1; i < tokens.size(); i++) {
            ArrayList<String> chunks = Input.tokenize(tokens.get(i), new String[]{",", " "});
            Integer[] curr = {0, 0, 0};
            for(int j = 1; j < chunks.size(); j+=2) {
                if(chunks.get(j).equals("red")) {
                    curr[0] = Integer.parseInt(chunks.get(j-1));
                }
                if(chunks.get(j).equals("green")) {
                    curr[1] = Integer.parseInt(chunks.get(j-1));
                }
                if(chunks.get(j).equals("blue")) {
                    curr[2] = Integer.parseInt(chunks.get(j-1));
                }
            }
            rounds.add(curr);
        }
        return new Game(id, rounds);
    }

}
