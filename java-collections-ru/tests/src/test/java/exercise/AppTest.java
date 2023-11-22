package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        Assertions.assertEquals(expected, App.take(list, 8));

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Assertions.assertEquals(expected, App.take(list, 0));

        expected.add(1);
        expected.add(2);
        expected.add(3);

        Assertions.assertEquals(expected, App.take(list, 3));

        expected.add(4);
        expected.add(5);


        Assertions.assertEquals(expected, App.take(list, 5));
        Assertions.assertEquals(expected, App.take(list, 8));
        // END
    }
}
