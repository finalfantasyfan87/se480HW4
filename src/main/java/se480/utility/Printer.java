package se480.utility;

import java.util.*;

import static java.util.Collections.*;

public class Printer {

    public Printer() { }

    public static void printTopTen(Map<String, Integer> stringIntegerMap) {
        // Algorithm taken from http://www.java2novice.com/java-interview-programs/sort-a-map-by-value/
        Set<Map.Entry<String, Integer>> set = stringIntegerMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);

        sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );

        list.stream().map(entry -> entry.getKey() + " : " + entry.getValue()).forEach(System.out::println);
    }
}
