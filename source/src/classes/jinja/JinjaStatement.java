package classes.jinja;

public abstract class JinjaStatement extends JinjaNode {

    @Override
    protected void printChildren(String indent) {
    }

    public JinjaStatement(int line, String name) {
        super(line, name);
    }
}
