package exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static LinkedHashMap<String, String> genDiff(Map<String, Object> dict1, Map<String, Object> dict2) {
        SortedSet<String> setFirstAndSecond = new TreeSet<>(dict1.keySet());
        setFirstAndSecond.retainAll(dict2.keySet());
        SortedSet<String> setFirstWithoutSecond = new TreeSet<>(dict1.keySet());
        setFirstWithoutSecond.removeAll(dict2.keySet());
        SortedSet<String> setSecondWithoutFirst = new TreeSet<>(dict2.keySet());
        setSecondWithoutFirst.removeAll(dict1.keySet());
        String[][] addedAndDeleted = Stream.concat(
                        setFirstWithoutSecond.stream()
                                .map(key -> new String[] {key, "deleted"}),
                        setSecondWithoutFirst.stream()
                                .map(key -> new String[] {key, "added"})
                )
                .toArray(String[][]::new);
        Function<String, String[]> changedOrUnchanged = key -> {
            if (dict1.get(key).equals(dict2.get(key))) {
                return new String[] {key, "unchanged"};
            } else {
                return new String[] {key, "changed"};
            }
        };
        return Stream.concat(Arrays.stream(addedAndDeleted),
                        setFirstAndSecond.stream()
                                .map(changedOrUnchanged)
                        )
                .sorted(Comparator.comparing(key -> key[0]))
                .collect(Collectors.toMap(kv -> kv[0], kv -> kv[1], (a, b) -> a, LinkedHashMap::new));
    }

}
//END
