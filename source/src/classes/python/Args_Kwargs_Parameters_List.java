package classes.python;

import classes.with_arr_ex;

import java.util.ArrayList;

public class Args_Kwargs_Parameters_List {
    private ArrayList<Args_Parameter> args_parameter_arraylist; //nullable
    private ArrayList<Kwargs_Parameter> kwargs_parameter_arraylist; //nullable

    public Args_Kwargs_Parameters_List() {
        this.args_parameter_arraylist = null;
        this.kwargs_parameter_arraylist = null;
    }

    public ArrayList<Args_Parameter> getArgs_parameter_arraylist() {
        if(args_parameter_arraylist == null){
            this.args_parameter_arraylist = new ArrayList<>();
        }
        return args_parameter_arraylist;
    }
    public void setArgs_parameter_arraylist(ArrayList<Args_Parameter> args_parameter_arraylist) {
        this.args_parameter_arraylist = args_parameter_arraylist;
    }
    public void add_to_args_parameter_arraylist(Args_Parameter ex){
        if(args_parameter_arraylist == null){
            this.args_parameter_arraylist = new ArrayList<>();
        }
        this.args_parameter_arraylist.add(ex);
    }

    public ArrayList<Kwargs_Parameter> getKwargs_parameter_arraylist() {
        if(kwargs_parameter_arraylist == null){
            this.kwargs_parameter_arraylist = new ArrayList<>();
        }
        return kwargs_parameter_arraylist;
    }
    public void setKwargs_parameter_arraylist(ArrayList<Kwargs_Parameter> kwargs_parameter_arraylist) {
        this.kwargs_parameter_arraylist = kwargs_parameter_arraylist;
    }
    public void add_to_ex_arraylist(Kwargs_Parameter ex){
        if(kwargs_parameter_arraylist == null){
            this.kwargs_parameter_arraylist = new ArrayList<>();
        }
        this.kwargs_parameter_arraylist.add(ex);
    }

    @Override
    public String toString() {
        String result = "\nArgs_Kwargs_Parameters_List{";
        if(args_parameter_arraylist != null) {
            result += "\nargs_parameter_arraylist=" + args_parameter_arraylist;
        }
        if(kwargs_parameter_arraylist != null) {
            result += "\nkwargs_parameter_arraylist=" + kwargs_parameter_arraylist;
        }
        result += "\n}";
        return result;
    }


}
