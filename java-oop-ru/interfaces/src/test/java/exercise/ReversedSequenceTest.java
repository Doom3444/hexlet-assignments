package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class ReversedSequenceTest {

    public final String text = "dcba";

    @Test
    void testLength() {
        assertThat((new ReversedSequence(text)).length()).isEqualTo(4);
    }

    @Test
    void testCharAt() {
        assertThat((new ReversedSequence(text)).charAt(0)).isEqualTo('a');
        assertThat((new ReversedSequence(text)).charAt(3)).isEqualTo('d');
    }

    @Test
    void testSubSequence() {
        assertThat((new ReversedSequence(text)).subSequence(0, 3)).isEqualTo("abc");
    }

    @Test
    void testToString() {
        assertThat((new ReversedSequence(text)).toString()).isEqualTo("abcd");
    }
}