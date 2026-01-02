package classes.html;


public class BooleanAttributeNode extends AttributeNode {

    public BooleanAttributeNode(int line, String name) {
        super(line, name);
    }

    @Override
    public String toString() {
        return "\nBooleanAttribute{" +
                "name='" + name + '\'' +
                '}';
    }
}
