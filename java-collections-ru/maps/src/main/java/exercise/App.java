package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> words = new HashMap<>();
        if (text.isEmpty()) {
            return words;
        }
        for (String word: text.split(" ")) {
            if (words.containsKey(word)) {
                words.replace(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
        return words;
    }
    public static String toString(Map<String, Integer> words) {
        if (words.isEmpty()) {
            return "{}";
        }
        StringBuilder dictionary = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> word: words.entrySet()) {
            dictionary.append("  ").append(word.getKey()).append(": ").append(word.getValue()).append("\n");
        }
        dictionary.append("}");
        return dictionary.toString();
    }
}
//END
