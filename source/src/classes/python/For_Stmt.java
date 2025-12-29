package classes.python;

public class For_Stmt extends Compound_Stmt{
    private Target_List target_list;
    private Expr expr;
    private Suite suite;

    public For_Stmt() {
        this.target_list = new Target_List();
        this.expr = new Expr();
        this.suite = new Suite();
    }

    public Target_List getTarget_list() {
        return target_list;
    }
    public void setTarget_list(Target_List target_list) {
        this.target_list = target_list;
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
        return "\nFor_Stmt{" +
                "\ntarget_list=" + target_list +
                "\n, expr=" + expr +
                "\n, suite=" + suite +
                "\n}";
    }
}
