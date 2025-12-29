package classes.python;

import java.util.ArrayList;

public class Tuple_Expr extends Expr{
    private ArrayList<Conditional_Expr> conditional_expr_arraylist;

    public Tuple_Expr() {
        this.conditional_expr_arraylist = new ArrayList<>();
    }

    public ArrayList<Conditional_Expr> getConditional_expr_arraylist() {
        return conditional_expr_arraylist;
    }
    public void setConditional_expr_arraylist(ArrayList<Conditional_Expr> conditional_expr_arraylist) {
        this.conditional_expr_arraylist = conditional_expr_arraylist;
    }


    public void add_to_conditional_expr_arraylist(Conditional_Expr ex){
        this.conditional_expr_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nTuple_Expr{" +
                "\nconditional_expr_arraylist=" + conditional_expr_arraylist +
                "\n}";
    }
}
