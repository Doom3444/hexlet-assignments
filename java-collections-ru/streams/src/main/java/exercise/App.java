package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(email -> email.endsWith("gmail.com"))
                .count()
                + emails.stream()
                .filter(email -> email.endsWith("yandex.ru"))
                .count()
                + emails.stream()
                .filter(email -> email.endsWith("hotmail.com"))
                .count();
    }
}
// END
