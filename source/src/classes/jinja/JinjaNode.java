package classes.jinja;

public abstract class JinjaNode {
    protected int line;
    protected String nodeName;

    public JinjaNode(int line, String nodeName) {
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
