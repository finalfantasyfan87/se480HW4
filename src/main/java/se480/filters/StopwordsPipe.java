package se480.filters;

import se480.utility.FrequentWords;

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

    public void removeStopWordsPushWordCounter(List<String> words) {
        Path stopFile = Paths.get("stopwords.txt");
        try {
            stopWords = Files.readAllLines(stopFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        words.removeIf(word -> stopWords.contains(word));
        FrequentWords.countWordsPushPrint(words);
    }

    public List convertFileToListOfWords(String fileName) throws IOException {
        Path file = Paths.get(fileName);
            wordList = Files.readAllLines(file);
        for (String words:wordList) {
            String[] splitWords = words.toLowerCase().trim().split("\\s+");
            List tempList = Arrays.asList(splitWords);
            //System.out.println(tempList);
//         //   if(!(tempList.isEmpty())){
           cleanedWordList.addAll(tempList);
//     //       }
        }
        return cleanedWordList;
        }

    }
