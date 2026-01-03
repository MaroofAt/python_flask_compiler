package classes.html;



public class TextNode extends HtmlNode {

    private String text;

    public TextNode(int line, String text) {
        super(line, "Text");
        this.text = text;
    }
    @Override
    protected void printChildren(String indent) {
        // لا أبناء
    }

    @Override
    public String toString() {
        return "\nTextNode{" +
                "text='" + text + '\'' +
                ", line=" + line +
                '}';
    }
}
