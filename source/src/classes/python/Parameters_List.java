package classes.python;

import classes.with_arr_ex;

import java.util.ArrayList;

public class Parameters_List {
    private ArrayList<Non_Default_Parameter> non_default_parameter_arraylist; //nullable
    private ArrayList<Default_Parameter> default_parameter_arraylist; //nullable
    private Args_Kwargs_Parameters_List args_kwargs_parameters_list; //nullable

    public Parameters_List() {
        this.non_default_parameter_arraylist = null;
        this.default_parameter_arraylist = null;
        this.args_kwargs_parameters_list = null;
    }

    public ArrayList<Non_Default_Parameter> getNon_default_parameter_arraylist() {
        if(non_default_parameter_arraylist == null){
            this.non_default_parameter_arraylist = new ArrayList<>();
        }
        return non_default_parameter_arraylist;
    }
    public void setNon_default_parameter_arraylist(ArrayList<Non_Default_Parameter> non_default_parameter_arraylist) {
        this.non_default_parameter_arraylist = non_default_parameter_arraylist;
    }
    public void add_to_non_default_parameter_arraylist(Non_Default_Parameter ex){
        if(non_default_parameter_arraylist == null){
            this.non_default_parameter_arraylist = new ArrayList<>();
        }
        this.non_default_parameter_arraylist.add(ex);
    }

    public ArrayList<Default_Parameter> getDefault_parameter_arraylist() {
        if(default_parameter_arraylist == null){
            this.default_parameter_arraylist = new ArrayList<>();
        }
        return default_parameter_arraylist;
    }
    public void setDefault_parameter_arraylist(ArrayList<Default_Parameter> default_parameter_arraylist) {
        this.default_parameter_arraylist = default_parameter_arraylist;
    }
    public void add_to_default_parameter_arraylist(Default_Parameter ex){
        if(default_parameter_arraylist == null){
            this.default_parameter_arraylist = new ArrayList<>();
        }
        this.default_parameter_arraylist.add(ex);
    }

    public Args_Kwargs_Parameters_List getArgs_kwargs_parameters_list() {
        if(args_kwargs_parameters_list == null){
            this.args_kwargs_parameters_list = new Args_Kwargs_Parameters_List();
        }
        return args_kwargs_parameters_list;
    }
    public void setArgs_kwargs_parameters_list(Args_Kwargs_Parameters_List args_kwargs_parameters_list) {
        this.args_kwargs_parameters_list = args_kwargs_parameters_list;
    }

    @Override
    public String toString() {
        String result = "\nParameters_List{";
        if(non_default_parameter_arraylist != null) {
            result += "\nnon_default_parameter_arraylist=" + non_default_parameter_arraylist;
        }
        if(default_parameter_arraylist != null) {
            result += "\ndefault_parameter_arraylist=" + default_parameter_arraylist;
        }
        if(args_kwargs_parameters_list != null) {
            result += "\nargs_kwargs_parameters_list=" + args_kwargs_parameters_list;
        }
        result += "\n}";
        return result;
    }
}
