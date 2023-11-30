package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {

    @Test
    void test_0() {
        String[][] empty = {};
        String[][] expected = {};
        assertThat(App.enlargeArrayImage(empty)).isEqualTo(expected);
    }

    @Test
    void test_1() {
        String[][] one = {{"*"}};
        String[][] expected = {
                {"*", "*"},
                {"*", "*"}
        };
        assertThat(App.enlargeArrayImage(one)).isEqualTo(expected);
    }

    @Test
    void test_3_1() {
        String[][] three = {
                {"*", "*", "*"},
                {"*", "*", "*"},
                {"*", "*", "*"},
        };
        String[][] expected = {
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
        };
        assertThat(App.enlargeArrayImage(three)).isEqualTo(expected);
    }

    @Test
    void test_3_2() {
        String[][] three = {
                {"*", "*", "*"},
                {"*", " ", "*"},
                {"*", "*", "*"},
        };
        String[][] expected = {
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
        };
        assertThat(App.enlargeArrayImage(three)).isEqualTo(expected);
    }

}
// END
