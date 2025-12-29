package classes.python;

public class Identifier_Equal_Expr_Argument {
    private Identifier identifier;
    private Expr expr;

    public Identifier_Equal_Expr_Argument() {
        this.identifier = new Identifier();
        this.expr = new Expr();
    }

    public Identifier getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "\nIdentifier_Equal_Expr_Argument{" +
                "\nidentifier=" + identifier +
                "\n, expr=" + expr +
                "\n}";
    }
}
