package se480.filters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class NonAlphaRemoverPipe {
List<String> alphaOnlyList = new ArrayList<>();

PorterStemmerPipe porterStemmerPipe = new PorterStemmerPipe();
/*Used as a blueprint for how to replace all nonAlpha in collection
    https://stackoverflow.com/questions/11149759/remove-all-non-alphabetic-characters-from-a-string-array-in-java/11149783*/

    public  List<String> removeNonAlphaChars(List<String> refactoredList){
        refactoredList.stream().map(word -> word.replaceAll("[^a-zA-Z0-9]", "")).filter(alphaOnly -> !alphaOnly.isEmpty()).forEachOrdered(alphaOnly -> alphaOnlyList.add(alphaOnly));
return alphaOnlyList;
    }

    public void writeToFile(List<String> data) throws IOException {
        Path file = Paths.get("tempFile.txt");
        Files.write(file, data);
    }

    public void callStemmerPipe(){ porterStemmerPipe.stemmerPipeWords("tempFile.txt");
    }
    }
