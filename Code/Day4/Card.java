package Code.Day4;

import java.util.ArrayList;

public class Card {

    public int cardID;
    
    public ArrayList<Integer> winningNums;
    public ArrayList<Integer> cardNums;

    public Card(int cardID, ArrayList<Integer> winningNums, ArrayList<Integer> cardNums) {
        this.cardID = cardID;
        this.winningNums = winningNums;
        this.cardNums = cardNums;
    }

}
