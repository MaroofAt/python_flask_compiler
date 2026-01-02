package classes.css;

public abstract class CssNode {
    protected int line;
    protected String nodeName;

    public CssNode(int line, String nodeName) {
        this.line = line;
        this.nodeName = nodeName;
    }

    public int getLine() {
        return line;
    }

    public String getNodeName() {
        return nodeName;
    }
}
