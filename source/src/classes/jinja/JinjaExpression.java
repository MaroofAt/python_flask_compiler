package classes.jinja;

public abstract class JinjaExpression extends JinjaNode {
    protected void printChildren(String indent) {
    }

    public JinjaExpression(int line, String name) {
        super(line, name);
    }
}
