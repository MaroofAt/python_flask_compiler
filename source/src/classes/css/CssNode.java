package classes.css;

public abstract class CssNode {

    protected int line;
    protected String nodeName;

    public CssNode(int line, String nodeName) {
        this.line = line;
        this.nodeName = nodeName;
    }

    public void print(String indent) {
        System.out.println(indent + nodeName + " (line " + line + ")");
        printChildren(indent + "  ");
    }

    protected abstract void printChildren(String indent);
}
