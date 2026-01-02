package classes.jinja;


public class LiteralExpr extends JinjaExpression {
    public String value;

    public LiteralExpr(int line, String value) {
        super(line, "LiteralExpr");
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
