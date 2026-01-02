package classes.html;


import java.util.ArrayList;

public class OpenTagNode extends HtmlNode {

    private String tagName;
    private ArrayList<AttributeNode> attributes;

    public OpenTagNode(int line, String tagName) {
        super(line, "OpenTag");
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
    }

    public void addAttribute(AttributeNode attr) {
        attributes.add(attr);
    }

    @Override
    public String toString() {
        return "\nOpenTag{" +
                "tagName='" + tagName + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
