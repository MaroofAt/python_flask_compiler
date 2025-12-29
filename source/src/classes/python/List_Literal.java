package classes.python;

public class List_Literal extends Atom_Enclosure{
    private Expr expr; //nullable

    public List_Literal() {
        this.expr = null;
    }

    public Expr getExpr() {
        if(expr == null){
            this.expr = new Expr();
        }
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "\nList_Literal{" +
                "\nexpr=" + expr +
                "\n}";
    }
}
