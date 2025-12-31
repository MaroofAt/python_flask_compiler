package classes.python;

import java.util.ArrayList;

public class Multiplication_Expr {
    ArrayList<Unary_Expr> unary_expr_arraylist;

    public Multiplication_Expr() {
        this.unary_expr_arraylist = new ArrayList<>();
    }

    public ArrayList<Unary_Expr> getUnary_expr_arraylist() {
        return unary_expr_arraylist;
    }
    public void setUnary_expr_arraylist(ArrayList<Unary_Expr> unary_expr_arraylist) {
        this.unary_expr_arraylist = unary_expr_arraylist;
    }

    public void add_to_unary_expr_arraylist(Unary_Expr ex){
        this.unary_expr_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nMultiplication_Expr{" +
                "\nunary_expr_arraylist=" + unary_expr_arraylist +
                "\n}";
    }
}
