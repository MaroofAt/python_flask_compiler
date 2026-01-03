package classes.jinja;

public class JinjaComment extends JinjaNode {

    public String content;

    public JinjaComment(int line, String content) {
        super(line, "Comment");
        this.content = content;
    }

    @Override
    protected void printChildren(String indent) {
    }

    @Override
    public String toString() {
        return "{# " + content + " #}";
    }
}
