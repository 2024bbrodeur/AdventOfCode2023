package Code.Day5;

import java.io.File;
import java.util.ArrayList;

import Code.Input;

public class Part1 {
    
    public static void main(String[] args) {
        ArrayList<String> lines = Input.getLines(new File("Code/Day5/input.txt"));
        Almanac almanac = createAlmanac(lines);
        long lowestLocation = getLowestLocation(almanac);
        System.out.println(lowestLocation);
    }

    public static long getLowestLocation(Almanac almanac) {
        long min = Long.MAX_VALUE;
        for(long seed : almanac.seeds) {
            min = Math.min(min, getLocation(seed, almanac));
        }
        return min;
    }

    public static long getLocation(long seed, Almanac almanac) {
        long currNum = seed;
        for(ArrayList<Long[]> map : almanac.maps) {
            currNum = patternMatch(currNum, map);
        }

        return currNum;
    }

    public static long patternMatch(long key, ArrayList<Long[]> map) {
        long value = key;
        for(Long[] mapItem : map) {
            if(key >= mapItem[1] && key - mapItem[1]+1 <= mapItem[2]) {
                value = mapItem[0] + (key-mapItem[1]);
                break;
            }
        }
        return value;
    }

    public static Almanac createAlmanac(ArrayList<String> lines) {
        String[] seedsString = lines.get(0).substring(7).split(" ");
        Long[] seeds = stringArrToLong(seedsString);

        int i = 3;
        ArrayList<Long[]> seedToSoil = new ArrayList<>();
        while(true) {
            if(lines.get(i).equals("")) break;
            seedToSoil.add(stringArrToLong(lines.get(i).split(" ")));
            i++;
        }

        i+=2;
        ArrayList<Long[]> soilToFertilizer = new ArrayList<>();
        while(true) {
            if(lines.get(i).equals("")) break;
            soilToFertilizer.add(stringArrToLong(lines.get(i).split(" ")));
            i++;
        }

        i+=2;
        ArrayList<Long[]> fertilizerToWater = new ArrayList<>();
        while(true) {
            if(lines.get(i).equals("")) break;
            fertilizerToWater.add(stringArrToLong(lines.get(i).split(" ")));
            i++;
        }

        i+=2;
        ArrayList<Long[]> waterToLight = new ArrayList<>();
        while(true) {
            if(lines.get(i).equals("")) break;
            waterToLight.add(stringArrToLong(lines.get(i).split(" ")));
            i++;
        }

        i+=2;
        ArrayList<Long[]> lightToTemperature = new ArrayList<>();
        while(true) {
            if(lines.get(i).equals("")) break;
            lightToTemperature.add(stringArrToLong(lines.get(i).split(" ")));
            i++;
        }

        i+=2;
        ArrayList<Long[]> temperatureToHumidity = new ArrayList<>();
        while(true) {
            if(lines.get(i).equals("")) break;
            temperatureToHumidity.add(stringArrToLong(lines.get(i).split(" ")));
            i++;
        }

        i+=2;
        ArrayList<Long[]> humidityToLocation = new ArrayList<>();
        while(true) {
            if(i >= lines.size()) break;
            humidityToLocation.add(stringArrToLong(lines.get(i).split(" ")));
            i++;
        }

        return new Almanac(seeds, seedToSoil, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, temperatureToHumidity, humidityToLocation);
    }

    public static Long[] stringArrToLong(String[] stringArr) {
        Long[] intArr = new Long[stringArr.length];
        for(int i = 0; i < stringArr.length; i++) {
            intArr[i] = Long.parseLong(stringArr[i]);
        }
        return intArr;
    }

}
