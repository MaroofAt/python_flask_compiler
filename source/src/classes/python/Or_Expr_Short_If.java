package classes.python;

public class Or_Expr_Short_If {
    private Or_Expr or_expr1;
    private Or_Expr or_expr2;
    private Conditional_Expr conditional_expr;

    public Or_Expr_Short_If() {
        this.or_expr1 = new Or_Expr();
        this.or_expr2 = new Or_Expr();
        this.conditional_expr = new Conditional_Expr();
    }

    public Or_Expr getOr_expr1() {
        return or_expr1;
    }
    public void setOr_expr1(Or_Expr or_expr1) {
        this.or_expr1 = or_expr1;
    }

    public Or_Expr getOr_expr2() {
        return or_expr2;
    }
    public void setOr_expr2(Or_Expr or_expr2) {
        this.or_expr2 = or_expr2;
    }

    public Conditional_Expr getConditional_expr() {
        return conditional_expr;
    }
    public void setConditional_expr(Conditional_Expr conditional_expr) {
        this.conditional_expr = conditional_expr;
    }

    @Override
    public String toString() {
        return "\nOr_Expr_Short_If{" +
                "\nor_expr1=" + or_expr1 +
                "\n, or_expr2=" + or_expr2 +
                "\n, conditional_expr=" + conditional_expr +
                "\n}";
    }
}
