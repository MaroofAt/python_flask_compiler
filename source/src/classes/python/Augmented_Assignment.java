package classes.python;

public class Augmented_Assignment extends Small_Stmt{
    private Target target;
    private Augmented_Assignment_Operator augmented_assignment_operator;
    private Expr expr;

    public Augmented_Assignment() {
        this.target = new Target();
        this.augmented_assignment_operator = new Augmented_Assignment_Operator();
        this.expr = new Expr();
    }

    public Target getTarget() {
        return target;
    }
    public void setTarget(Target target) {
        this.target = target;
    }

    public Augmented_Assignment_Operator getAugmented_assignment_operator() {
        return augmented_assignment_operator;
    }
    public void setAugmented_assignment_operator(Augmented_Assignment_Operator augmented_assignment_operator) {
        this.augmented_assignment_operator = augmented_assignment_operator;
    }

    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "\nAugmented_Assignment{" +
                "\ntarget=" + target +
                "\n, augmented_assignment_operator=" + augmented_assignment_operator +
                "\n, expr=" + expr +
                "\n}";
    }
}
