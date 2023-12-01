package Code.Day1;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part2 {
    
    public static void main(String[] args) {
        ArrayList<String> input = Input.getLines(new File("Code/Day1/input.txt"));

        System.out.println(sumOfCalibrationValues(input));
    }

    public static int sumOfCalibrationValues(ArrayList<String> lines) {

        int sum = 0;

        for(String line : lines) {
            sum += getFirstLastDigit(line);
        }

        return sum;
    }

    public static int getFirstLastDigit(String line) {

        String digits = "";

        for(int i = 0; i < line.length(); i++) {
            try {
                digits += Integer.parseInt(line.substring(i, i+1));
                break;
            } catch(Exception e) {
                try {
                    if(line.substring(i, i+3).equals("one")) {
                        digits += 1;
                        break;
                    }
                    if(line.substring(i, i+3).equals("two")) {
                        digits += 2;
                        break;
                    }
                    if(line.substring(i, i+3).equals("six")) {
                        digits += 6;
                        break;
                    }
                    if(line.substring(i, i+4).equals("zero")) {
                        digits += 0;
                        break;
                    }
                    if(line.substring(i, i+4).equals("four")) {
                        digits += 4;
                        break;
                    }
                    if(line.substring(i, i+4).equals("five")) {
                        digits += 5;
                        break;
                    }
                    if(line.substring(i, i+4).equals("nine")) {
                        digits += 9;
                        break;
                    }
                    if(line.substring(i, i+5).equals("three")) {
                        digits += 3;
                        break;
                    }
                    if(line.substring(i, i+5).equals("seven")) {
                        digits += 7;
                        break;
                    }
                    if(line.substring(i, i+5).equals("eight")) {
                        digits += 8;
                        break;
                    }
                } catch(Exception f) {
                    continue;
                }
            }
        }

        for(int i = line.length()-1; i >= 0; i--) {
            try {
                digits += Integer.parseInt(line.substring(i, i+1));
                break;
            } catch(Exception e) {
                try {
                    if(line.substring(i, i+3).equals("one")) {
                        digits += 1;
                        break;
                    }
                    if(line.substring(i, i+3).equals("two")) {
                        digits += 2;
                        break;
                    }
                    if(line.substring(i, i+3).equals("six")) {
                        digits += 6;
                        break;
                    }
                    if(line.substring(i, i+4).equals("zero")) {
                        digits += 0;
                        break;
                    }
                    if(line.substring(i, i+4).equals("four")) {
                        digits += 4;
                        break;
                    }
                    if(line.substring(i, i+4).equals("five")) {
                        digits += 5;
                        break;
                    }
                    if(line.substring(i, i+4).equals("nine")) {
                        digits += 9;
                        break;
                    }
                    if(line.substring(i, i+5).equals("three")) {
                        digits += 3;
                        break;
                    }
                    if(line.substring(i, i+5).equals("seven")) {
                        digits += 7;
                        break;
                    }
                    if(line.substring(i, i+5).equals("eight")) {
                        digits += 8;
                        break;
                    }
                } catch(Exception f) {
                    continue;
                }
            }
        }

        return Integer.parseInt(digits);
        
    }

}
