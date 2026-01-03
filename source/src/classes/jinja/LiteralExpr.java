package classes.jinja;


public class LiteralExpr extends JinjaExpression {
    public String value;

    public LiteralExpr(int line, String value) {
        super(line, "LiteralExpr");
        this.value = value;
    }
    protected void printChildren(String indent) {
    }

    public String toString() {
        return value;
    }
}
