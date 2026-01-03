package classes.html;



public class NormalAttributeNode extends AttributeNode {

    private String value;

    public NormalAttributeNode(int line, String name, String value) {
        super(line, name);
        this.value = value;
    }

    @Override
    protected void printChildren(String indent) {

    }


    @Override
    public String toString() {
        return "\nNormalAttribute{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
