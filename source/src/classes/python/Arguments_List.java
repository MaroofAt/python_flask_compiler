package classes.python;

import classes.with_arr_ex;

import java.util.ArrayList;

public class Arguments_List {
    private ArrayList<Expr> expr_arraylist; //nullable
    private ArrayList<Identifier_Equal_Expr_Argument> identifier_equal_expr_argument_arraylist; //nullable
    private ArrayList<Args_Argument> args_argument_arraylist; //nullable
    private ArrayList<Kwargs_Argument> kwargs_argument_arraylist; //nullable

    public Arguments_List() {
        this.expr_arraylist = null;
        this.identifier_equal_expr_argument_arraylist = null;
        this.args_argument_arraylist = null;
        this.kwargs_argument_arraylist = null;
    }

    public ArrayList<Expr> getExpr_arraylist() {
        if(expr_arraylist == null){
            this.expr_arraylist = new ArrayList<>();
        }
        return expr_arraylist;
    }
    public void setExpr_arraylist(ArrayList<Expr> expr_arraylist) {
        this.expr_arraylist = expr_arraylist;
    }
    public void add_to_expr_arraylist(Expr ex){
        if(expr_arraylist == null){
            this.expr_arraylist = new ArrayList<>();
        }
        this.expr_arraylist.add(ex);
    }

    public ArrayList<Identifier_Equal_Expr_Argument> getIdentifier_equal_expr_argument_arraylist() {
        if(identifier_equal_expr_argument_arraylist == null){
            this.identifier_equal_expr_argument_arraylist = new ArrayList<>();
        }
        return identifier_equal_expr_argument_arraylist;
    }
    public void setIdentifier_equal_expr_argument_arraylist(ArrayList<Identifier_Equal_Expr_Argument> identifier_equal_expr_argument_arraylist) {
        this.identifier_equal_expr_argument_arraylist = identifier_equal_expr_argument_arraylist;
    }
    public void add_to_ex_arraylist(Identifier_Equal_Expr_Argument ex){
        if(identifier_equal_expr_argument_arraylist == null){
            this.identifier_equal_expr_argument_arraylist = new ArrayList<>();
        }
        this.identifier_equal_expr_argument_arraylist.add(ex);
    }

    public ArrayList<Args_Argument> getArgs_argument_arraylist() {
        if(args_argument_arraylist == null){
            this.args_argument_arraylist = new ArrayList<>();
        }
        return args_argument_arraylist;
    }
    public void setArgs_argument_arraylist(ArrayList<Args_Argument> args_argument_arraylist) {
        this.args_argument_arraylist = args_argument_arraylist;
    }
    public void add_to_ex_arraylist(Args_Argument ex){
        if(args_argument_arraylist == null){
            this.args_argument_arraylist = new ArrayList<>();
        }
        this.args_argument_arraylist.add(ex);
    }

    public ArrayList<Kwargs_Argument> getKwargs_argument_arraylist() {
        if(kwargs_argument_arraylist == null){
            this.kwargs_argument_arraylist = new ArrayList<>();
        }
        return kwargs_argument_arraylist;
    }
    public void setKwargs_argument_arraylist(ArrayList<Kwargs_Argument> kwargs_argument_arraylist) {
        this.kwargs_argument_arraylist = kwargs_argument_arraylist;
    }
    public void add_to_ex_arraylist(Kwargs_Argument ex){
        if(kwargs_argument_arraylist == null){
            this.kwargs_argument_arraylist = new ArrayList<>();
        }
        this.kwargs_argument_arraylist.add(ex);
    }


    @Override
    public String toString() {
        String result = "\nArguments_List{";
        if(expr_arraylist != null) {
            result += "\nexpr_arraylist=" + expr_arraylist;
        }
        if(identifier_equal_expr_argument_arraylist != null) {
            result += "\nidentifier_equal_expr_argument_arraylist=" + identifier_equal_expr_argument_arraylist;
        }
        if(args_argument_arraylist != null) {
            result += "\nargs_argument_arraylist=" + args_argument_arraylist;
        }
        if(kwargs_argument_arraylist != null) {
            result += "\nkwargs_argument_arraylist=" + kwargs_argument_arraylist;
        }
        result += "\n}";
        return result;
    }


}
