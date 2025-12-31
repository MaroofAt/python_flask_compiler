package classes.python;

import java.util.ArrayList;

public class And_Expr {
    ArrayList<Not_Expr> not_expr_arraylist;

    public And_Expr() {
        this.not_expr_arraylist = new ArrayList<>();
    }

    public ArrayList<Not_Expr> getNot_expr_arraylist() {
        return not_expr_arraylist;
    }
    public void setNot_expr_arraylist(ArrayList<Not_Expr> not_expr_arraylist) {
        this.not_expr_arraylist = not_expr_arraylist;
    }

    public void add_to_not_expr_arraylist(Not_Expr ex){
        this.not_expr_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nAnd_Expr{" +
                "\nnot_expr_arraylist=" + not_expr_arraylist +
                "\n}";
    }
}
