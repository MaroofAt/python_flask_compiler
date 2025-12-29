package classes.python;

public class While_Stmt extends Compound_Stmt{
    private Expr expr;
    private Suite suite;

    public While_Stmt() {
        this.expr = new Expr();
        this.suite = new Suite();
    }

    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public Suite getSuite() {
        return suite;
    }
    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString() {
        return "\nWhile_Stmt{" +
                "\nexpr=" + expr +
                "\n, suite=" + suite +
                "\n}";
    }
}
