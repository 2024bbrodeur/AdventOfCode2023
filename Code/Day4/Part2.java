package Code.Day4;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part2 {
    
    public static void main(String[] args) {
        ArrayList<String> lines = Input.getLines(new File("Code/Day4/input.txt"));
        ArrayList<Card> cards = Part1.createCards(lines);
        int totalNumOfCards = getTotalNumOfCards(cards);

        System.out.println(totalNumOfCards);
    }

    public static int getTotalNumOfCards(ArrayList<Card> cards) {
        int[] numOfCards = new int[cards.size()];
        for(int i = 0; i < numOfCards.length; i++) {
            numOfCards[i] = 1;
        }

        for(int i = 0; i < cards.size(); i++) {
            int numOfNewCards = getNumOfNewCards(cards.get(i));
            for(int j = i+1; j < i+1 + numOfNewCards; j++) {
                numOfCards[j] += numOfCards[i];
            }
        }

        int sum = 0;
        for(int i : numOfCards) {
            sum += i;
        }

        return sum;

    }

    public static int getNumOfNewCards(Card card) {
        int matches = 0;
        for(int i = 0; i < card.cardNums.size(); i++) {
            for(int j = 0; j < card.winningNums.size(); j++) {
                if(card.cardNums.get(i) == card.winningNums.get(j)) {
                    matches++;
                }
            }
        }

        return matches;
    }

}
