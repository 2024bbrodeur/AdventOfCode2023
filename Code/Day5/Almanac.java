package Code.Day5;

import java.util.ArrayList;

public class Almanac {
    
    public Long[] seeds;
    public ArrayList<ArrayList<Long[]>> maps;

    public Almanac(
        Long[] seeds, ArrayList<Long[]> seedToSoil, ArrayList<Long[]> soilToFertilizer, ArrayList<Long[]> fertilizerToWater,
        ArrayList<Long[]> waterToLight, ArrayList<Long[]> lightToTemperature, ArrayList<Long[]> temperatureToHumidity, ArrayList<Long[]> humidityToLocation
    ) {
        this.seeds = seeds;
        maps = new ArrayList<>();
        maps.add(seedToSoil);
        maps.add(soilToFertilizer);
        maps.add(fertilizerToWater);
        maps.add(waterToLight);
        maps.add(lightToTemperature);
        maps.add(temperatureToHumidity);
        maps.add(humidityToLocation);
    }

}
