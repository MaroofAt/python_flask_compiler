package classes.html;



public abstract class ElementNode extends HtmlNode {
    @Override
    protected void printChildren(String indent) {

    }

    public ElementNode(int line, String nodeName) {
        super(line, nodeName);
    }
}
