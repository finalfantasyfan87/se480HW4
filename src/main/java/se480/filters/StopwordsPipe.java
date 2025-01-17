package se480.filters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StopwordsPipe {
    List<String> stopWords;
    List<String> wordList;
    List<String> cleanedWordList = new ArrayList<>();

/*    references for using lamba removeIf
    https://howtodoinjava.com/java/collections/arraylist/arraylist-removeif/*/
    public List<String> removeStopWordsPushWordCounter(List<String> words) {
        Path stopFile = Paths.get("stopwords.txt");
        try {
            stopWords = Files.readAllLines(stopFile);
            System.out.println("Stopwords list size before filter: " + words.size());
            words.removeIf(word -> stopWords.contains(word));
            System.out.println("Stopwords list size after filter: " + words.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
return words;
    }

    public List convertFileToListOfWords(String fileName) throws IOException {
        Path file = Paths.get(fileName);
            wordList = Files.readAllLines(file);
        wordList.stream().map(words -> words.toLowerCase().trim().split("\\s+")).map(Arrays::asList).forEachOrdered(tempList -> cleanedWordList.addAll(tempList));
        return cleanedWordList;
        }

    }
