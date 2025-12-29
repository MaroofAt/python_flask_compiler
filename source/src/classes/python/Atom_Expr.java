package classes.python;

public class Atom_Expr extends Atom{
    private Expr expr;

    public Atom_Expr() {
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
        return "\nAtom_Expr{" +
                "\nexpr=" + expr +
                "\n}";
    }
}
