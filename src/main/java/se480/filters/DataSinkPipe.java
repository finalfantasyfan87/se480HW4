package se480.filters;

import java.util.*;
import java.util.stream.Collectors;

public class DataSinkPipe {

    public DataSinkPipe(){}

    public List<Map.Entry<String, Integer>> generate10Frequent(ArrayList<String> words){
        long startTime = System.currentTimeMillis();
        Map<String, Integer> map = words.stream().collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(map.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<Map.Entry<String, Integer>> frequentWords = new ArrayList<>();
        long limit = 10;
        for (Map.Entry<String, Integer> entry : sorted) {
            if (limit-- == 0) break;
            frequentWords.add(entry);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total DataSinkPipe Execution time in ms: " + (endTime - startTime));
        System.out.println(frequentWords.toString());
        return frequentWords;
    }


}
