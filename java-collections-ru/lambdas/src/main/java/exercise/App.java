package exercise;

import java.util.Arrays;

// BEGIN
public class App {

    public static String[][] enlargeArrayImage(String[][] array) {
        return Arrays.stream(array)
                .map(arr -> Arrays.stream(arr)
                        .map(e -> new String[]{e, e})
                        .flatMap(Arrays::stream)
                        .toArray(String[]::new)
                )
                .map(arr -> new String[][]{arr, arr})
                .flatMap(Arrays::stream)
                .toArray(String[][]::new);
    }

}
// END