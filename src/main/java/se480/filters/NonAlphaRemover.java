package se480.filters;

import java.util.ArrayList;
import java.util.List;

public class NonAlphaRemover {
List<String> alphaOnlyList = new ArrayList<>();
    public  List<String> removeNonAlphaChars(List<String> refactoredList){
        for (String word : refactoredList) {
            String alphaOnly = word.replaceAll("[^a-zA-Z0-9]", "");
            if (!alphaOnly.isEmpty()){
                alphaOnlyList.add(alphaOnly);
            }
        }
System.out.println(alphaOnlyList);
return alphaOnlyList;
    }

    }
