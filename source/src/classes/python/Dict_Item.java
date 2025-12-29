package classes.python;

public class Dict_Item {
    private Expr expr1;
    private Expr expr2;

    public Dict_Item() {
        this.expr1 = new Expr();
        this.expr2 = new Expr();
    }

    public Expr getExpr1() {
        return expr1;
    }

    public void setExpr1(Expr expr1) {
        this.expr1 = expr1;
    }

    public Expr getExpr2() {
        return expr2;
    }

    public void setExpr2(Expr expr2) {
        this.expr2 = expr2;
    }

    @Override
    public String toString() {
        return "\nDict_Item{" +
                "\nexpr1=" + expr1 +
                "\n, expr2=" + expr2 +
                "\n}";
    }
}
