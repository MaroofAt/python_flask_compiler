package classes.python;


import java.util.ArrayList;

public class Regular_Assignment extends Assignment{
    private ArrayList<Target_List> target_list_arraylist;
    private Expr expr;

    public Regular_Assignment() {
        this.target_list_arraylist = new ArrayList<>();
        this.expr = new Expr();
    }

    public ArrayList<Target_List> getTarget_list_arraylist() {
        return target_list_arraylist;
    }

    public void setTarget_list_arraylist(ArrayList<Target_List> target_list_arraylist) {
        this.target_list_arraylist = target_list_arraylist;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public void add_to_target_list_arraylist(Target_List ex){
        this.target_list_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nRegular_Assignment{" +
                "\ntarget_list_arraylist=" + target_list_arraylist +
                "\n}";
    }

}
