package classes.python;


import java.util.ArrayList;

public class Set_Items {
    private ArrayList<Expr> expr_arraylist;

    public Set_Items() {
        this.expr_arraylist = new ArrayList<>();
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

    @Override
    public String toString() {
        return "\nSet_Items{" +
                "\nexpr_arraylist=" + expr_arraylist +
                "\n}";
    }
}
