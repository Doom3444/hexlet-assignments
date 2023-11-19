package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        if (word.isEmpty()) {
            return true;
        }
        if (symbols.length() < word.length()) {
            return false;
        }
        String[] lettersFromWord = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            lettersFromWord[i] = "" + word.charAt(i);
        }
        List<String> letters = new ArrayList<>();
        for (int i = 0; i < symbols.length(); i++) {
            letters.add("" + symbols.charAt(i));
        }
        int sizeBefore = letters.size();
        for (int i = 0; i < word.length(); i++) {
            letters.remove(lettersFromWord[i].toLowerCase());
        }
        int sizeAfter = letters.size();
        return sizeAfter + word.length() == sizeBefore;
    }
}
//END
