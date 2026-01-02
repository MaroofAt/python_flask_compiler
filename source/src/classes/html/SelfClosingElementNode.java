package classes.html;

import java.util.ArrayList;

public class SelfClosingElementNode extends ElementNode {

    private String tagName;
    private ArrayList<AttributeNode> attributes;

    public SelfClosingElementNode(int line, String tagName) {
        super(line, "SelfClosingElement");
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
    }

    public void addAttribute(AttributeNode attr) {
        attributes.add(attr);
    }

    @Override
    public String toString() {
        return "\nSelfClosingElement{" +
                "\n tagName='" + tagName + '\'' +
                "\n attributes=" + attributes +
                "\n}";
    }
}
