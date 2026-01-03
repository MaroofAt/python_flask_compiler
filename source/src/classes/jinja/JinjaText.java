package classes.jinja;

public class JinjaText extends JinjaNode {

    public String text;

    public JinjaText(int line, String text) {
        super(line, "Text");
        this.text = text;
    }
    @Override
    protected void printChildren(String indent) {
    }

    @Override
    public String toString() {
        return text;
    }
}
