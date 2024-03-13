package exercise;

import java.util.Map;

// BEGIN
public class Tag {

    private final String tagName;
    private final Map<String, String> attributes;

    protected Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    protected String getTagName() {
        return tagName;
    }

    protected String getAttributesToString() {
        if (attributes.isEmpty()) {
            return "";
        }
        StringBuilder attributesToString = new StringBuilder();
        for (Map.Entry<String, String> elem: attributes.entrySet()) {
            attributesToString.append(" ")
                    .append(elem.getKey())
                    .append("=\"")
                    .append(elem.getValue())
                    .append("\"");
        }
        return attributesToString.toString();
    }

    @Override
    public String toString() {
        return "<" + getTagName() +
                getAttributesToString() +
                ">";
    }
}
// END
