package classes.html;



public abstract class AttributeNode extends HtmlNode {

    protected String name;

    public AttributeNode(int line, String name) {
        super(line, "Attribute");
        this.name = name;
    }
}
