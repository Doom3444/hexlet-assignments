package exercise;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {

    public static String getForwardedVariables(String content) {
        String[] confInfo = Arrays.stream(content
                        .replaceAll("environment=\"", "\"environment")
                        .split("\""))
                .filter(str -> str.startsWith("environment"))
                .map(str -> str.replace("environment", ""))
                .map(str -> str.split(","))
                .flatMap(Arrays::stream)
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .map(str -> str.replace("X_FORWARDED_", ""))
                .toArray(String[]::new);
        return String.join(",", confInfo);
    }

}
//END
