package classes.html;

public abstract class HtmlNode {
    protected int line;
    protected String nodeName;

    public HtmlNode(int line, String nodeName) {
        this.line = line;
        this.nodeName = nodeName;
    }

    public int getLine() {
        return line;
    }

    public String getNodeName() {
        return nodeName;
    }

    @Override
    public abstract String toString();
}
