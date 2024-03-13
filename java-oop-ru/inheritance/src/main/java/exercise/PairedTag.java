package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {

    private final String tagBody;
    private final List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> children) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.children = children;
    }

    public String getTagBody() {
        return tagBody;
    }

    public String getChildrenToString() {
        if (children.isEmpty()) {
            return "";
        }
        StringBuilder childrenToString = new StringBuilder();
        for (Tag elem: children) {
            childrenToString.append(elem.toString());
        }
        return childrenToString.toString();
    }

    @Override
    public String toString() {
        return "<" + getTagName() +
                getAttributesToString() +
                ">" +
                tagBody +
                getChildrenToString() +
                "</" + getTagName() + ">";
    }
}
// END
