package se480;


import se480.filters.NonAlphaRemoverPipe;
import se480.filters.StopwordsPipe;

import java.io.IOException;
import java.util.List;

public class PipeFilterDemo {

    public static void main(String[] args) throws IOException {
        StopwordsPipe stopwordsPipe = new StopwordsPipe();
        List words = stopwordsPipe.convertFileToListOfWords(args[0]);
        List updatedList = stopwordsPipe.removeStopWordsPushWordCounter(words);
        NonAlphaRemoverPipe nonAlphaRemover = new NonAlphaRemoverPipe();
        List alphaChars = nonAlphaRemover.removeNonAlphaChars(updatedList);
        nonAlphaRemover.writeToFile(alphaChars);
        nonAlphaRemover.callStemmerPipe();
    }

}
