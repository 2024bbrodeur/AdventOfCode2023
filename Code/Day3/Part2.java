package Code.Day3;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part2 {
    
    public static void main(String[] args) {
        char[][] schematic = Input.get2DArray(new File("Code/Day3/input.txt"));
        System.out.println(getGearSum(schematic));

    }

    public static int getGearSum(char[][] schematic) {
        int sum = 0;

        for(int i = 0; i < schematic.length; i++) {
            for(int j = 0; j < schematic.length; j++) {
                if(schematic[i][j] == '*') {
                    ArrayList<Integer> adjNums = getAdjNums(schematic, i, j);
                    if(adjNums.size() == 2) {
                        sum += adjNums.get(0) * adjNums.get(1);
                    }
                }
            }
        }

        return sum;
    }

    public static ArrayList<Integer> getAdjNums(char[][] schematic, int i, int j) {
        ArrayList<Integer> adjNums = new ArrayList<>();
        if(!isNextToNumber(schematic, i, j)) return adjNums;
        if(i > 0) {
            boolean lastWasNum = false;
            for(int k = (j > 0) ? j-1 : j; k < (j < schematic[i].length-1 ? j+2 : j+1); k++) {
                if(isNumber(schematic[i-1][k])) {
                    if(lastWasNum) continue;
                    adjNums.add(getFullNum(schematic, i-1, k));
                    lastWasNum = true;
                } else {
                    lastWasNum = false;
                }
            }
        }
        if(i < schematic.length-1) {
            boolean lastWasNum = false;
            for(int k = (j > 0) ? j-1 : j; k < (j < schematic[i].length-1 ? j+2 : j+1); k++) {
                if(isNumber(schematic[i+1][k])) {
                    if(lastWasNum) continue;
                    adjNums.add(getFullNum(schematic, i+1, k));
                    lastWasNum = true;
                } else {
                    lastWasNum = false;
                }
            }
        }
        if(j > 0) {
            if(isNumber(schematic[i][j-1])) {
                adjNums.add(getFullNum(schematic, i, j-1));
            }
        }
        if(j < schematic[i].length-1) {
            if(isNumber(schematic[i][j+1])) {
                adjNums.add(getFullNum(schematic, i, j+1));
            }
        }

        return adjNums;

    }

    public static int getFullNum(char[][] schematic, int i, int j) {
        int start = 0;
        for(int k = j; k >= 0; k--) {
            if(!isNumber(schematic[i][k])) {
                start = k+1;
                break;
            } else if(k == 0) {
                start = k;
                break;
            }
        }

        String num = "";
        while(true) {
            if(isNumber(schematic[i][start])) {
                num += schematic[i][start];
                start++;
            } else {
                break;
            }
            if(start == schematic[i].length) break;
        }

        return Integer.parseInt(num);
    }

    public static boolean isNextToNumber(char[][] schematic, int i, int j) {
        boolean nextToNumber = false;
        nextToNumber = nextToNumber || (i > 0 && isNumber(schematic[i-1][j]));
        nextToNumber = nextToNumber || (i < schematic.length-1 && isNumber(schematic[i+1][j]));
        nextToNumber = nextToNumber || (j > 0 && isNumber(schematic[i][j-1]));
        nextToNumber = nextToNumber || (j < schematic[i].length-1 && isNumber(schematic[i][j+1]));
        //diagonals
        nextToNumber = nextToNumber || (i > 0 && j > 0 && isNumber(schematic[i-1][j-1]));
        nextToNumber = nextToNumber || (i > 0 && j < schematic[i-1].length-1 && isNumber(schematic[i-1][j+1]));
        nextToNumber = nextToNumber || (i < schematic.length-1 && j > 0 && isNumber(schematic[i+1][j-1]));
        nextToNumber = nextToNumber || (i < schematic.length-1 && j < schematic[i+1].length-1 && isNumber(schematic[i+1][j+1]));

        return nextToNumber;
    }

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
    
    public static boolean isSymbol(char c) {
        return c != '.' && !isNumber(c);
    }

}
