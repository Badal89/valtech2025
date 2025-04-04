package codility;

import java.util.*;

public class VowelSorter {

    
    private static int calculateVowelCount(String text) {
        int vowelCount = 0;
        String vowelChars = "aeiouAEIOU";
        for (char character : text.toCharArray()) {
            if (vowelChars.indexOf(character) >= 0) {
                vowelCount++;
            }
        }
        return vowelCount;
    }

    public static void main(String[] args) {

       
        List<String> sentenceList = new ArrayList<>(Arrays.asList(
            "This is a test sentence.",
            "Hello World!",
            "Java programming is fun.",
            "Sorting sentences by vowels."
        ));

       
        sentenceList.sort(Comparator.comparingInt(VowelSorter::calculateVowelCount));

       
        System.out.println("Sentences sorted by the number of vowels:");
        for (String sentence : sentenceList) {
            System.out.println(sentence + " (Vowels: " + calculateVowelCount(sentence) + ")");
        }
    }
}