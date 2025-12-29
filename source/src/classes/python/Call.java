package classes.python;

import java.util.ArrayList;

public class Call extends Postfix{
    private Arguments_List arguments_list; //nullable

    public Call() {
        this.arguments_list = null;
    }

    public Arguments_List getArguments_list() {
        if(arguments_list == null){
            this.arguments_list = new Arguments_List();
        }
        return arguments_list;
    }
    public void setArguments_list(Arguments_List arguments_list) {
        this.arguments_list = arguments_list;
    }

    @Override
    public String toString() {
        String result = "\nCall{";
        if(arguments_list != null) {
            result += "\narguments_list=" + arguments_list;
        }
        result += "\n}";
        return result;
    }
}
