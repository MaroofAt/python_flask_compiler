package classes.html;


import java.util.ArrayList;

public class NormalElementNode extends ElementNode {

    private OpenTagNode openTag;
    private ArrayList<HtmlNode> content;
    private CloseTagNode closeTag;

    public NormalElementNode(int line, OpenTagNode openTag, CloseTagNode closeTag) {
        super(line, "NormalElement");
        this.openTag = openTag;
        this.closeTag = closeTag;
        this.content = new ArrayList<>();
    }

    public void addContent(HtmlNode node) {
        content.add(node);
    }

    @Override
    public String toString() {
        return "\nNormalElement{" +
                "\n openTag=" + openTag +
                "\n content=" + content +
                "\n closeTag=" + closeTag +
                "\n}";
    }
}
