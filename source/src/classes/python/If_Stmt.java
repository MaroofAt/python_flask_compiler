package classes.python;

import classes.with_arr_ex;

import java.util.ArrayList;

public class If_Stmt extends Compound_Stmt{
    private ArrayList<Expr> expr_arraylist;
    private ArrayList<Suite> suite_arraylist;

    public If_Stmt() {
        this.expr_arraylist = new ArrayList<>();
        this.suite_arraylist = new ArrayList<>();
    }

    public ArrayList<Expr> getExpr_arraylist() {
        return expr_arraylist;
    }
    public void setExpr_arraylist(ArrayList<Expr> expr_arraylist) {
        this.expr_arraylist = expr_arraylist;
    }
    public void add_to_ex_arraylist(Expr ex){
        this.expr_arraylist.add(ex);
    }

    public ArrayList<Suite> getSuite_arraylist() {
        return suite_arraylist;
    }
    public void setSuite_arraylist(ArrayList<Suite> suite_arraylist) {
        this.suite_arraylist = suite_arraylist;
    }
    public void add_to_ex_arraylist(Suite ex){
        this.suite_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nIf_Stmt{" +
                "\nexpr_arraylist=" + expr_arraylist +
                "\n, suite_arraylist=" + suite_arraylist +
                "\n}";
    }
}
