package classes.jinja;


public class UnaryExpr extends JinjaExpression {

    public String operator;
    public JinjaExpression expr;

    public UnaryExpr(int line, String operator, JinjaExpression expr) {
        super(line, "UnaryExpr");
        this.operator = operator;
        this.expr = expr;
    }
    @Override
    protected void printChildren(String indent) {
        expr.print(indent);
    }

    public String toString() {
        return operator + expr;
    }
}
