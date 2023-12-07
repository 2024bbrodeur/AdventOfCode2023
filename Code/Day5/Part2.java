package Code.Day5;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part2 {
    
    public static void main(String[] args) {
        ArrayList<String> lines = Input.getLines(new File("Code/Day5/input.txt"));
        Almanac almanac = Part1.createAlmanac(lines);
        long lowestLocation = getLowestLocation(almanac);
        System.out.println(lowestLocation);
    }

    public static long getLowestLocation(Almanac almanac) {
        long min = Long.MAX_VALUE;
        for(int i = 0; i < Long.MAX_VALUE; i++) {
            long start = getStart(i, almanac);
            if(inSeeds(start, almanac)) return i;
        }
        return min;
    }

    public static boolean inSeeds(long num, Almanac almanac) {
        for(int i = 0; i < almanac.seeds.length; i+=2) {
            if(num >= almanac.seeds[i] && num < almanac.seeds[i] + almanac.seeds[i+1]) return true;
        }
        return false;
    }

    public static long getStart(long start, Almanac almanac) {
        long currNum = start;
        
        for(int i = almanac.maps.size()-1; i >= 0; i--) {
            currNum = patternMatch(currNum, almanac.maps.get(i));
        }

        return currNum;
    }

    public static long patternMatch(long key, ArrayList<Long[]> map) {
        long value = key;
        for(Long[] mapItem : map) {
            if(key >= mapItem[0] && key - mapItem[0]+1 <= mapItem[2]) {
                value = mapItem[1] + (key-mapItem[0]);
                break;
            }
        }
        return value;
    }


}
