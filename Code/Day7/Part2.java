package Code.Day7;

import java.util.HashMap;
import java.util.HashSet;


public class Part2 {
    
    public static void main(String[] args) {
        String[][] hands = Part1.getInput();

        int totalWinnings = getTotalWinnings(hands);
        System.out.println(totalWinnings);
    }

    public static int getTotalWinnings(String[][] hands) {
        String[][] sortedHands = sortHands(hands);
        int sum = 0;
        for(int i = 0; i < sortedHands.length; i++) {
            sum += (i+1) * Integer.parseInt(sortedHands[i][1]);
        }
        return sum;
    }

    public static String[][] sortHands(String[][] hands) {
        String[][] sortedHands = new String[hands.length][2];
        int currWorst = -1;
        HashSet<Integer> visited = new HashSet<>();
        for(int count = 0; count < hands.length; count++) {
            for(int i = 0; i < hands.length; i++) {
                if(visited.contains(i)) continue;
                if(currWorst == -1) currWorst = i;
                else {
                    if(worseHand(hands[i][0], hands[currWorst][0])) currWorst = i;
                }
            }
            sortedHands[count] = hands[currWorst];
            visited.add(currWorst);
            currWorst = -1;
        }
        return sortedHands;
    }

    public static boolean worseHand(String hand1, String hand2) {
        if(getHand(hand1) < getHand(hand2)) return true;
        if(getHand(hand1) > getHand(hand2)) return false;

        String hand1Revised = "";
        String hand2Revised = "";
        for(int i = 0; i < hand1.length(); i++) {
            if(isDigit(hand1.charAt(i))) {
                hand1Revised += hand1.charAt(i);
            } else if(hand1.charAt(i) == 'T') {
                hand1Revised += (char)('9' + 1);
            } else if(hand1.charAt(i) == 'J') {
                hand1Revised += (char)('2' - 1);
            } else if(hand1.charAt(i) == 'Q') {
                hand1Revised += (char)('9' + 3);
            } else if(hand1.charAt(i) == 'K') {
                hand1Revised += (char)('9' + 4);
            } else if(hand1.charAt(i) == 'A') {
                hand1Revised += (char)('9' + 5);
            }
            if(isDigit(hand2.charAt(i))) {
                hand2Revised += hand2.charAt(i);
            } else if(hand2.charAt(i) == 'T') {
                hand2Revised += (char)('9' + 1);
            } else if(hand2.charAt(i) == 'J') {
                hand2Revised += (char)('2' - 1);
            } else if(hand2.charAt(i) == 'Q') {
                hand2Revised += (char)('9' + 3);
            } else if(hand2.charAt(i) == 'K') {
                hand2Revised += (char)('9' + 4);
            } else if(hand2.charAt(i) == 'A') {
                hand2Revised += (char)('9' + 5);
            }
        }

        for(int i = 0; i < hand1Revised.length(); i++) {
            if(hand1Revised.charAt(i) < hand2Revised.charAt(i)) return true;
            if(hand1Revised.charAt(i) > hand2Revised.charAt(i)) return false;
        }

        return false;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static int getHand(String hand) {
        HashMap<Character, Integer> map = new HashMap<>();
        int numOfJ = 0;
        for(int i = 0; i < hand.length(); i++) {
            if(hand.charAt(i) == 'J') {
                numOfJ++;
                continue;
            }
            if(map.containsKey(hand.charAt(i))) {
                map.put(hand.charAt(i), map.remove(hand.charAt(i))+1);
            } else {
                map.put(hand.charAt(i), 1);
            }
        }

        int max = 0;
        Character maxC = '1';

        for(Character key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                maxC = key;
            }
        }


        if(max == 0) {
            map.put('J', 5);
        } else
            map.put(maxC, map.remove(maxC)+numOfJ);

        int five = 0;
        int four = 0;
        int three = 0;
        int two = 0;

        for(Integer value : map.values()) {
            if(value == 5) five = 1;
            if(value == 4) four = 1;
            if(value == 3) three = 1;
            if(value == 2) two++;
        }

        if(five == 1) return 7;
        if(four == 1) return 6;
        if(three == 1 && two == 1) return 5;
        if(three == 1) return 4;
        if(two == 2) return 3;
        if(two == 1) return 2;

        return 1;
    }

}
