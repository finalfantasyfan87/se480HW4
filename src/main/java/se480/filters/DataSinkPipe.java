package se480.filters;

import java.util.*;
import java.util.stream.Collectors;

public class DataSinkPipe {

    public DataSinkPipe(){}

    public List<Map.Entry<String, Long>> generate10Frequent(ArrayList<String> words){
        long startTime = System.currentTimeMillis();
        Map<String, Long> map = words.stream().collect(Collectors.toMap(word -> word, word -> 1L, Long::sum));

        List<Map.Entry<String, Long>> toSort = new ArrayList<>(map.entrySet());
        toSort.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<Map.Entry<String, Long>> result = new ArrayList<>();
        long limit = 10;
        for (Map.Entry<String, Long> entry : toSort) {
            if (limit-- == 0) break;
            result.add(entry);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("DataSinkPipe Execution time: " + (endTime - startTime));
        System.out.println(result.toString());
        return result;
    }


}
