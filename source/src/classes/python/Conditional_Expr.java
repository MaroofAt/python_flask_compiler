package classes.python;

import java.util.ArrayList;

public class Conditional_Expr {
    private Or_Expr or_expr; //nullable
    private Or_Expr_Short_If or_expr_short_if; //nullable

    public Conditional_Expr() {
        this.or_expr = null;
        this.or_expr_short_if = null;
    }

    public Or_Expr getOr_expr() {
        if(or_expr == null){
            this.or_expr = new Or_Expr();
        }
        return or_expr;
    }
    public void setOr_expr(Or_Expr or_expr) {
        this.or_expr = or_expr;
    }
    public Or_Expr_Short_If getOr_expr_short_if() {
        if(or_expr_short_if == null){
            this.or_expr_short_if = new Or_Expr_Short_If();
        }
        return or_expr_short_if;
    }
    public void setOr_expr_short_if(Or_Expr_Short_If or_expr_short_if) {
        this.or_expr_short_if = or_expr_short_if;
    }

    @Override
    public String toString() {
        String result = "\nConditional_Expr{";
        if(or_expr != null) {
            result += "or_expr=" + or_expr;
        }else if(or_expr_short_if != null) {
            result += "or_expr_short_if=" + or_expr_short_if;
        }
        result += "\n}";
        return result;
    }
}
