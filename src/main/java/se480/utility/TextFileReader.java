package se480.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextFileReader {
    List<String> fileContentsList;

    public List<String> readTextFile(String textFile) {
        try {
            Path file = Paths.get(textFile);
            fileContentsList = Files.readAllLines(file);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return fileContentsList;
    }
}