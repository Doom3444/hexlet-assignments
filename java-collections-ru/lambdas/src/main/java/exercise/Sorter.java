package exercise;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        Function<Map<String,String>, LocalDate> df = h -> LocalDate.parse(h.get("birthday"));
        return list.stream()
                .filter(human -> human.get("gender").equals("male"))
                .sorted(Comparator.comparing(df))
                .map(human -> human.get("name"))
                .collect(Collectors.toList());
    }

}
// END
