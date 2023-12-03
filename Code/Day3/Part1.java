package Code.Day3;

import java.io.File;

import Code.Input;

public class Part1 {
    
    public static void main(String[] args) {
        char[][] schematic = Input.get2DArray(new File("Code/Day3/input.txt"));
        System.out.println(getSchematicSum(schematic));

    }

    public static int getSchematicSum(char[][] schematic) {
        boolean currNextToSymbol = false;
        String currNum = "";
        int sum = 0;

        for(int i = 0; i < schematic.length; i++) {
            for(int j = 0; j < schematic[i].length; j++) {
                if(isNumber(schematic[i][j])) {
                    currNum += schematic[i][j];
                    currNextToSymbol = currNextToSymbol || isNextToSymbol(schematic, i, j);
                } else if(!currNum.equals("") && currNextToSymbol) {
                    sum += Integer.parseInt(currNum);
                    currNum = "";
                    currNextToSymbol = false;
                } else {
                    currNum = "";
                }

                if(j == schematic[i].length-1) {
                    if(!currNum.equals("") && currNextToSymbol) sum += Integer.parseInt(currNum);
                    currNum = "";
                    currNextToSymbol = false;
                }
            }
        }

        return sum;

    }

    public static boolean isNextToSymbol(char[][] schematic, int i, int j) {
        boolean nextToSymbol = false;
        nextToSymbol = nextToSymbol || (i > 0 && isSymbol(schematic[i-1][j]));
        nextToSymbol = nextToSymbol || (i < schematic.length-1 && isSymbol(schematic[i+1][j]));
        nextToSymbol = nextToSymbol || (j > 0 && isSymbol(schematic[i][j-1]));
        nextToSymbol = nextToSymbol || (j < schematic[i].length-1 && isSymbol(schematic[i][j+1]));
        //diagonals
        nextToSymbol = nextToSymbol || (i > 0 && j > 0 && isSymbol(schematic[i-1][j-1]));
        nextToSymbol = nextToSymbol || (i > 0 && j < schematic[i-1].length-1 && isSymbol(schematic[i-1][j+1]));
        nextToSymbol = nextToSymbol || (i < schematic.length-1 && j > 0 && isSymbol(schematic[i+1][j-1]));
        nextToSymbol = nextToSymbol || (i < schematic.length-1 && j < schematic[i+1].length-1 && isSymbol(schematic[i+1][j+1]));

        return nextToSymbol;
    }

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
    
    public static boolean isSymbol(char c) {
        return c != '.' && !isNumber(c);
    }

}
