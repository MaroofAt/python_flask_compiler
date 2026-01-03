package classes.jinja;

public class NameExpr extends JinjaExpression {
    public String name;

    public NameExpr(int line, String name) {
        super(line, "NameExpr");
        this.name = name;
    }
    protected void printChildren(String indent) {
    }


    public String toString() {
        return name;
    }
}
