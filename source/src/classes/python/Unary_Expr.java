package classes.python;


import java.util.ArrayList;

public class Unary_Expr {
    private ArrayList<Unary_Op> unary_op_arraylist; //nullable
    private Power_Expr power_expr;

    public Unary_Expr() {
        this.power_expr = power_expr;
        this.unary_op_arraylist = null;
    }

    public ArrayList<Unary_Op> getUnary_op_arraylist() {
        if(unary_op_arraylist == null){
            this.unary_op_arraylist = new ArrayList<>();
        }
        return unary_op_arraylist;
    }
    public void setUnary_op_arraylist(ArrayList<Unary_Op> unary_op_arraylist) {
        this.unary_op_arraylist = unary_op_arraylist;
    }
    public void add_to_unary_op_arraylist(Unary_Op ex){
        this.unary_op_arraylist.add(ex);
    }

    public Power_Expr getPower_expr() {
        return power_expr;
    }
    public void setPower_expr(Power_Expr power_expr) {
        this.power_expr = power_expr;
    }

    @Override
    public String toString() {
        String result = "\nUnary_Expr{"
                + "\npower_expr=" + power_expr;
        if(unary_op_arraylist != null) {
            result += "\nunary_op_arraylist=" + unary_op_arraylist;
        }
        result += "\n}";
        return result;
    }


}
