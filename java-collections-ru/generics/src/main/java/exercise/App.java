package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> neededBook) {
        List<Map<String, String>> result = new ArrayList<>();
        if (!neededBook.isEmpty()) {
            for (Map<String, String> iteratorL: books) {
                if (correctBook(iteratorL, neededBook)) {
                    result.add(iteratorL);
                }
            }
        }
        return result;
    }
    public static boolean correctBook(Map<String, String> book1, Map<String, String> book2) {
        for (Map.Entry<String, String> iterator: book2.entrySet()) {
            if (!book1.get(iterator.getKey()).equals(iterator.getValue())) {
                return false;
            }
        }
        return true;
    }
}
//END
