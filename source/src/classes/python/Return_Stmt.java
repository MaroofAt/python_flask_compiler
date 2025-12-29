package classes.python;

public class Return_Stmt extends Small_Stmt{
    private Expr expr;

    public Return_Stmt() {
        this.expr = new Expr();
    }

    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "\nReturn_Stmt{" +
                "\nexpr=" + expr +
                "\n}";
    }
}
