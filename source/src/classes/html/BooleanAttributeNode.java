package classes.html;


public class BooleanAttributeNode extends AttributeNode {

    public BooleanAttributeNode(int line, String name) {
        super(line, name);
    }

    @Override
    protected void printChildren(String indent) {

    }


    @Override
    public String toString() {
        return "\nBooleanAttribute{" +
                "name='" + name + '\'' +
                '}';
    }
}
