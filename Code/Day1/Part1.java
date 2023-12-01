package Code.Day1;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part1 {

    public static void main(String[] args) {
        System.out.println(sumOfCalibrationValues(Input.getLines(new File("Code/Day1/input.txt"))));
        
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
            if(isDigit(line.substring(i, i+1))) {
                digits += line.substring(i, i+1);
                break;
            }
        }

        for(int i = line.length()-1; i >= 0; i--) {
            if(isDigit(line.substring(i, i+1))) {
                digits += line.substring(i, i+1);
                break;
            }
        }

        return Integer.parseInt(digits);
    }

    public static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}