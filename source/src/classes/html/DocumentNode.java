package classes.html;


import java.util.ArrayList;

public class DocumentNode extends HtmlNode {

    private ArrayList<HtmlNode> elements;

    public DocumentNode(int line) {
        super(line, "Document");
        this.elements = new ArrayList<>();
    }

    public void addElement(HtmlNode element) {
        elements.add(element);
    }

    public ArrayList<HtmlNode> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "\nDocumentNode{" +
                "\n elements=" + elements +
                "\n}";
    }
}
