package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String getTagName() {
        return super.getTagName();
    }

    @Override
    public String getAttributesToString() {
        return super.getAttributesToString();
    }
}
// END
