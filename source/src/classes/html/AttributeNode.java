package classes.html;



public abstract class AttributeNode extends HtmlNode {

    protected String name;

    @Override
    protected void printChildren(String indent) {
 
    }


    public AttributeNode(int line, String name) {
        super(line, "Attribute");
        this.name = name;
    }
}
