package classes.python;

import java.util.ArrayList;

public class Or_Expr {
    ArrayList<And_Expr> and_expr_arraylist;

    public Or_Expr() {
        this.and_expr_arraylist = new ArrayList<>();
    }

    public ArrayList<And_Expr> getAnd_expr_arraylist() {
        return and_expr_arraylist;
    }
    public void setAnd_expr_arraylist(ArrayList<And_Expr> and_expr_arraylist) {
        this.and_expr_arraylist = and_expr_arraylist;
    }

    public void add_to_and_expr_arraylist(And_Expr ex){
        this.and_expr_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nOr_Expr{" +
                "\nand_expr_arraylist=" + and_expr_arraylist +
                "\n}";
    }
}
