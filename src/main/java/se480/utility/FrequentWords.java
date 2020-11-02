package se480.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentWords {



    public static Map<String, Integer> mapped(List<String> words) {
        Map<String, Integer> mappedWords = new HashMap<>();
        mapWords(words);
        return mappedWords;
    }



    private static void mapWords(List<String> words) {
        Map<String, Integer> mappedWords = new HashMap<>();

        words.forEach(word -> {
            if (mappedWords.containsKey(word)) {
                mappedWords.put(word, mappedWords.get(word) + 1);
            }
            mappedWords.put(word, 1);
        });
    }

    public static void countWordsPushPrint(List<String> words) {
        mapWords(words);
        Printer.printTopTen(mapped(words));
    }
}
