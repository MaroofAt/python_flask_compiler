
package classes.jinja;

public class BinaryExpr extends JinjaExpression {

    public JinjaExpression left;
    public String operator;
    public JinjaExpression right;

    public BinaryExpr(int line, JinjaExpression left, String operator, JinjaExpression right) {
        super(line, "BinaryExpr");
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public String toString() {
        return "(" + left + " " + operator + " " + right + ")";
    }
}
