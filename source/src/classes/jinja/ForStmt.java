package classes.jinja;


public class ForStmt extends JinjaStatement {





    public String variable;
    public JinjaExpression iterable;
    public JinjaBody body;

    public ForStmt(int line, String variable, JinjaExpression iterable, JinjaBody body) {
        super(line, "ForStmt");
        this.variable = variable;
        this.iterable = iterable;
        this.body = body;
    }
    @Override
    protected void printChildren(String indent) {
        iterable.print(indent);
        body.print(indent);
    }

    public String toString() {
        return "\nFor(" + variable + " in " + iterable + ")" + body;
    }
}
