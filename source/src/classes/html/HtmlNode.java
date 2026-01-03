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

    public void print(String indent) {
        System.out.println(indent + nodeName + " (line " + line + ")");
        printChildren(indent + "  ");
    }


    protected abstract void printChildren(String indent);
}