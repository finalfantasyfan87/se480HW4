package se480.filters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataSinkPipe {

    public DataSinkPipe(){}

    public List<Map.Entry<String, Long>> OrderTopTen(ArrayList<String> morphologicalRootsArrayList){
        long startTime = System.currentTimeMillis();
        Map<String, Long> map = morphologicalRootsArrayList.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        List<Map.Entry<String, Long>> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        System.out.println("DataSinkPipe Execution time: " + (endTime - startTime));
        System.out.println(result.toString());
        return result;
    }


}
