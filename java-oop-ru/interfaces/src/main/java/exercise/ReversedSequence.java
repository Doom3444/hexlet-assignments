package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    String text;
    ReversedSequence(String text) {
        StringBuilder reversedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            reversedText.append(text.charAt(text.length() - 1 - i));
        }
        this.text = reversedText.toString();
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return text.subSequence(start, end);
    }

    @Override
    public String toString() {
        return text;
    }
}
// END
