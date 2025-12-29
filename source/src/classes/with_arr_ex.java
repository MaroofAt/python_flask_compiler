package classes;

import java.util.ArrayList;

public class with_arr_ex{
    private class Ex{

    }
    private ArrayList<Ex> ex_arraylist;

    public ArrayList<Ex> getEx_arraylist() {
        if(ex_arraylist == null){
            this.ex_arraylist = new ArrayList<>();
        }
        return ex_arraylist;
    }

    public void setEx_arraylist(ArrayList<Ex> ex_arraylist) {
        this.ex_arraylist = ex_arraylist;
    }

    public void add_to_ex_arraylist(Ex ex){
        if(ex_arraylist == null){
            this.ex_arraylist = new ArrayList<>();
        }
        this.ex_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nwith_arr_ex{" +
                "\nex_arraylist=" + ex_arraylist +
                "\n}";
    }
    /*
    @Override
    public String toString() {
        String result = "\nNot_Expr{";
        if(not_expr != null) {
            result += "\nnot_expr=" + not_expr;
        }else if(comparison != null) {
            result += "\ncomparison=" + comparison;
        }
        result += "\n}";
        return result;
    }
     */
}
