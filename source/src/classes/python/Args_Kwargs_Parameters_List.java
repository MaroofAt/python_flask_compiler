package classes.python;

import java.util.ArrayList;

public class Args_Kwargs_Parameters_List {
    private Args_Parameter args_parameter; //nullable
    private Kwargs_Parameter kwargs_parameter; //nullable

    public Args_Kwargs_Parameters_List() {
        this.args_parameter = null;
        this.kwargs_parameter = null;
    }

    public Args_Parameter getArgs_parameter() {
        if(args_parameter == null){
            this.args_parameter = new Args_Parameter();
        }
        return args_parameter;
    }
    public void setArgs_parameter(Args_Parameter args_parameter) {
        this.args_parameter = args_parameter;
    }

    public Kwargs_Parameter getKwargs_parameter() {
        if(kwargs_parameter == null){
            this.kwargs_parameter = new Kwargs_Parameter();
        }
        return kwargs_parameter;
    }
    public void setKwargs_parameter(Kwargs_Parameter kwargs_parameter) {
        this.kwargs_parameter = kwargs_parameter;
    }

    @Override
    public String toString() {
        String result = "\nArgs_Kwargs_Parameters_List{";
        if(args_parameter != null) {
            result += "\nargs_parameter=" + args_parameter;
        }
        if(kwargs_parameter != null) {
            result += "\n, kwargs_parameter=" + kwargs_parameter;
        }
        result += "\n}";
        return result;
    }


}
