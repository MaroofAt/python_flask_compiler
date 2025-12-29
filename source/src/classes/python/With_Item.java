package classes.python;

public class With_Item {
    private Expr expr;
    private Target target; //nullable

    public With_Item() {
        this.expr = new Expr();
        this.target = null;
    }

    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public Target getTarget() {
        if(target == null){
            this.target = new Target();
        }
        return target;
    }
    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public String toString() {
        String result = "\nWith_Item{" +
                "\nexpr=" + expr;
        if(target != null) {
            result += "\n, target=" + target;
        }
        result += "\n}";
        return result;
    }
}
