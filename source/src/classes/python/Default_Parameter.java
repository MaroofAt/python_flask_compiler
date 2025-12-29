package classes.python;

public class Default_Parameter {
    private Non_Default_Parameter non_default_parameter;
    private Expr expr;

    public Default_Parameter() {
        this.non_default_parameter = new Non_Default_Parameter();
        this.expr = new Expr();
    }

    public Non_Default_Parameter getNon_default_parameter() {
        return non_default_parameter;
    }
    public void setNon_default_parameter(Non_Default_Parameter non_default_parameter) {
        this.non_default_parameter = non_default_parameter;
    }

    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "\nDefault_Parameter{" +
                "\nnon_default_parameter=" + non_default_parameter +
                "\n, expr=" + expr +
                "\n}";
    }
}
