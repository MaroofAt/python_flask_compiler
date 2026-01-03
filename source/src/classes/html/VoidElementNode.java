package classes.html;

import java.util.ArrayList;

public class VoidElementNode extends ElementNode {

    private String tagName;
    private ArrayList<AttributeNode> attributes;

    public VoidElementNode(int line, String tagName) {
        super(line, "VoidElement");
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
    }

    public void addAttribute(AttributeNode attr) {
        attributes.add(attr);
    }

    @Override
    protected void printChildren(String indent) {
        for (AttributeNode a : attributes) {
            a.print(indent);
        }
    }


    @Override
    public String toString() {
        return "\nVoidElement{" +
                "\n tagName='" + tagName + '\'' +
                "\n attributes=" + attributes +
                "\n}";
    }
}
