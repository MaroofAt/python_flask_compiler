public class NameExpr extends JinjaExpression {
    public String name;

    public NameExpr(int line, String name) {
        super(line, "NameExpr");
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
