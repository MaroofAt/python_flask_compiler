package classes.python;

public class Subscription extends Postfix{
    private Expr expr;

    public Subscription() {
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
        return "\nSubscription{" +
                "\nexpr=" + expr +
                "\n}";
    }
}
