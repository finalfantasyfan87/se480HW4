package se480;


import se480.filters.NonAlphaRemover;
import se480.filters.StopwordsPipe;
import se480.utility.TextFileReader;

import java.io.IOException;
import java.util.List;

public class PipeFilterDemo {
    static TextFileReader textFileReader;

    public static void main(String[] args) throws IOException {
    //    TextFileReader reader = new TextFileReader();
 //       List<String> textFileContents = reader.readTextFile(args[0]);

        StopwordsPipe stopwordsPipe = new StopwordsPipe();
        List words = stopwordsPipe.convertFileToListOfWords(args[0]);
        List updatedList = stopwordsPipe.removeStopWordsPushWordCounter(words);
        NonAlphaRemover nonAlphaRemover = new NonAlphaRemover();
        List alphaChars = nonAlphaRemover.removeNonAlphaChars(updatedList);
        nonAlphaRemover.writeToFile(alphaChars);
        nonAlphaRemover.callStemmerPipe();
    }

}
