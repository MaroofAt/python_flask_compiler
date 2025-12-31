package classes.python;

import java.util.ArrayList;

public class Xor_Expr extends Arithmetic_Expr{
    private ArrayList<Addition_Expr> addition_expr_arraylist;

    public Xor_Expr() {
        this.addition_expr_arraylist = new ArrayList<>();
    }

    public ArrayList<Addition_Expr> getAddition_expr_arraylist() {
        return addition_expr_arraylist;
    }
    public void setAddition_expr_arraylist(ArrayList<Addition_Expr> addition_expr_arraylist) {
        this.addition_expr_arraylist = addition_expr_arraylist;
    }

    public void add_to_addition_expr_arraylist(Addition_Expr ex){
        this.addition_expr_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nXor_Expr{" +
                "\naddition_expr_arraylist=" + addition_expr_arraylist +
                "\n}";
    }
}
