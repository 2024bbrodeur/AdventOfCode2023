package Code.Day4;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part1 {
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ArrayList<String> lines = Input.getLines(new File("Code/Day4/input.txt"));
        ArrayList<Card> cards = createCards(lines);
        int pointSum = pointSumOfCards(cards);

        System.out.println(pointSum);
        System.out.println("Time Taken: " + ((System.currentTimeMillis() - startTime)/1000.));
    }

    public static int pointSumOfCards(ArrayList<Card> cards) {
        int sum = 0;
        for(Card card : cards) {
            sum += pointSumOfCard(card);
        }
        return sum;
    }

    public static int pointSumOfCard(Card card) {
        int points = 0;
        for(int i = 0; i < card.cardNums.size(); i++) {
            for(int j = 0; j < card.winningNums.size(); j++) {
                if(card.cardNums.get(i) == card.winningNums.get(j)) {
                    if(points == 0) {
                        points = 1;
                        continue;
                    }
                    points *= 2;
                }
            }
        }

        return points;
    }

    public static ArrayList<Card> createCards(ArrayList<String> lines) {
        ArrayList<Card> cards = new ArrayList<>();
        for(String line : lines) {
            cards.add(createCard(line));
        }
        return cards;
    }

    public static Card createCard(String line) {
        ArrayList<String> tokens1 = Input.tokenize(line, new String[] {" "});
        String[] tokens = new String[tokens1.size()];
        for(int i = 0; i < tokens1.size(); i++) {
            tokens[i] = tokens1.get(i);
        }
        int id = Integer.parseInt(tokens[1].substring(0, tokens[1].length()-1));
        ArrayList<Integer> winningNums = new ArrayList<>();
        ArrayList<Integer> cardNums = new ArrayList<>();
        int i = 2;
        for(; i < tokens.length; i++) {
            if(tokens[i].equals("|")) break;
            winningNums.add(Integer.parseInt(tokens[i]));
        }

        for(i = i+1;i < tokens.length; i++) {
            cardNums.add(Integer.parseInt(tokens[i]));
        }

        return new Card(id, winningNums, cardNums);
    }

}
