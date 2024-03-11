package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {

    public static void swapKeyValue(KeyValueStorage map) {
        for (Map.Entry<String, String> e: map.toMap().entrySet()) {
            map.set(e.getValue(), e.getKey());
            map.unset(e.getKey());
        }
    }
}
// END
