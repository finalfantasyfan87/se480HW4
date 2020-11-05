package se480;


import se480.filters.NonAlphaRemoverPipe;
import se480.filters.StopwordsPipe;

import java.io.IOException;
import java.util.List;

public class PipeFilterDemo {

    public static void main(String[] args) throws IOException {
        StopwordsPipe stopwordsPipe = new StopwordsPipe();
        //running from the command line or IDE, ADD THE FILE NAME as
        //a program argument
        List words = stopwordsPipe.convertFileToListOfWords(args[0]);
        //update the list of words by removing all stopwords
        List updatedList = stopwordsPipe.removeStopWordsPushWordCounter(words);

        //call the nonAlphaPipeRemover to remove all nonAlpha characters
        NonAlphaRemoverPipe nonAlphaRemover = new NonAlphaRemoverPipe();
        List alphaChars = nonAlphaRemover.removeNonAlphaChars(updatedList);

        nonAlphaRemover.writeToFile(alphaChars);
        nonAlphaRemover.callStemmerPipe();
    }

}
