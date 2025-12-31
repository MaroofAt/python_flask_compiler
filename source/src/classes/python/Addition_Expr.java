package classes.python;

import java.util.ArrayList;

public class Addition_Expr {
    ArrayList<Multiplication_Expr> multiplication_expr_arraylist;

    public Addition_Expr() {
        this.multiplication_expr_arraylist = new ArrayList<>();
    }

    public ArrayList<Multiplication_Expr> getMultiplication_expr_arraylist() {
        return multiplication_expr_arraylist;
    }
    public void setMultiplication_expr_arraylist(ArrayList<Multiplication_Expr> multiplication_expr_arraylist) {
        this.multiplication_expr_arraylist = multiplication_expr_arraylist;
    }

    public void add_to_multiplication_expr_arraylist(Multiplication_Expr ex){
        this.multiplication_expr_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nAddition_Expr{" +
                "\nmultiplication_expr_arraylist=" + multiplication_expr_arraylist +
                "\n}";
    }
}
