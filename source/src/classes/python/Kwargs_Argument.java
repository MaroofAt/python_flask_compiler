package classes.python;

public class Kwargs_Argument {
    private Expr expr;

    public Kwargs_Argument() {
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
        return "\nKwargs_Argument{" +
                "\nexpr=" + expr +
                "\n}";
    }
}
