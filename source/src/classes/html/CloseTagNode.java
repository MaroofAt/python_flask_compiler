package classes.html;


public class CloseTagNode extends HtmlNode {

    private String tagName;

    public CloseTagNode(int line, String tagName) {
        super(line, "CloseTag");
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "\nCloseTag{" +
                "tagName='" + tagName + '\'' +
                '}';
    }
}
