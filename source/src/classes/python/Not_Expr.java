package classes.python;

import java.util.ArrayList;

public class Not_Expr {
    private Not_Expr not_expr; //nullable
    private Comparison comparison; //nullable

    public Not_Expr() {
        this.not_expr = null;
        this.comparison = null;
    }

    public Not_Expr getNot_expr() {
        if(not_expr == null){
            this.not_expr = new Not_Expr();
        }
        return not_expr;
    }
    public void setNot_expr(Not_Expr not_expr) {
        this.not_expr = not_expr;
    }
    public Comparison getComparison() {
        if(comparison == null){
            this.comparison = new Comparison();
        }
        return comparison;
    }
    public void setComparison(Comparison comparison) {
        this.comparison = comparison;
    }

    @Override
    public String toString() {
        String result = "\nNot_Expr{";
        if(not_expr != null) {
            result += "\nnot_expr=" + not_expr;
        }else if(comparison != null) {
            result += "\ncomparison=" + comparison;
        }
        result += "\n}";
        return result;
    }
}
