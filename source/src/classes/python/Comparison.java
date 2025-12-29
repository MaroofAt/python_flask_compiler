package classes.python;

import classes.with_arr_ex;

import java.util.ArrayList;

public class Comparison {
    private ArrayList<Arithmetic_Expr> arithmetic_expr_arraylist;
    private ArrayList<Comparision_Operator> comparision_operator_arraylist; //nullable

    public Comparison() {
        this.arithmetic_expr_arraylist = new ArrayList<>();
        this.comparision_operator_arraylist = null;
    }

    public ArrayList<Arithmetic_Expr> getArithmetic_expr_arraylist() {
        return arithmetic_expr_arraylist;
    }
    public void setArithmetic_expr_arraylist(ArrayList<Arithmetic_Expr> arithmetic_expr_arraylist) {
        this.arithmetic_expr_arraylist = arithmetic_expr_arraylist;
    }
    public void add_to_arithmetic_expr_arraylist(Arithmetic_Expr ex){
        this.arithmetic_expr_arraylist.add(ex);
    }

    public ArrayList<Comparision_Operator> getComparision_operator_arraylist() {
        if(comparision_operator_arraylist == null){
            this.comparision_operator_arraylist = new ArrayList<>();
        }
        return comparision_operator_arraylist;
    }
    public void setComparision_operator_arraylist(ArrayList<Comparision_Operator> comparision_operator_arraylist) {
        this.comparision_operator_arraylist = comparision_operator_arraylist;
    }

    public void add_to_comparision_operator_arraylist(Comparision_Operator ex){
        this.comparision_operator_arraylist.add(ex);
    }

    @Override
    public String toString() {
        String result = "\nComparison{" +
                "\narithmetic_expr_arraylist=" + arithmetic_expr_arraylist;
        if(comparision_operator_arraylist != null){
            result += "\ncomparision_operator_arraylist=" + comparision_operator_arraylist;
        }
        result += "\n}";
        return result;
    }

}
