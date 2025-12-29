package classes.python;

public class Args_Argument {
    private Expr expr;

    public Args_Argument() {
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
        return "\nArgs_Argument{" +
                "\nexpr=" + expr +
                "\n}";
    }
}
