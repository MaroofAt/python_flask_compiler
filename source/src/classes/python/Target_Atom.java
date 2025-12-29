package classes.python;

import java.util.ArrayList;

public class Target_Atom {
    private Identifier identifier; //nullable
    private Target_List target_list; //nullable

    public Target_Atom() {
        this.identifier = null;
        this.target_list = null;
    }

    public Identifier getIdentifier() {
        if(identifier == null){
            this.identifier = new Identifier();
        }
        return identifier;
    }
    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }
    public Target_List getTarget_list() {
        if(target_list == null){
            this.target_list = new Target_List();
        }
        return target_list;
    }
    public void setTarget_list(Target_List target_list) {
        this.target_list = target_list;
    }

    @Override
    public String toString() {
        String result = "\nTarget_Atom{";
        if(identifier != null) {
            result += "\nidentifier=" + identifier;
        }else if(target_list != null) {
            result += "\n, target_list=" + target_list;
        }
        result += "\n}";
        return result;
    }
}
