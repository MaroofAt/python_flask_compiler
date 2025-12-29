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
}
