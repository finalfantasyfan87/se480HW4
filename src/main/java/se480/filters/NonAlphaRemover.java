package se480.filters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NonAlphaRemover {
List<String> alphaOnlyList = new ArrayList<>();

PorterStemmerPipe porterStemmerPipe = new PorterStemmerPipe();
    public  List<String> removeNonAlphaChars(List<String> refactoredList){
        refactoredList.stream().map(word -> word.replaceAll("[^a-zA-Z0-9]", "")).filter(alphaOnly -> !alphaOnly.isEmpty()).forEachOrdered(alphaOnly -> alphaOnlyList.add(alphaOnly));
System.out.println(alphaOnlyList);
return alphaOnlyList;
    }

    public void writeToFile(List<String> data) throws IOException {
        Path file = Paths.get("tempFile.txt");
        Files.write(file, data);
    }

    public void callStemmerPipe(){
        ArrayList<String> strings = porterStemmerPipe.stemmerPipeWords("tempFile.txt");
        System.out.println("Calling stemmerpipe");
        System.out.println(strings);
    }
    }
