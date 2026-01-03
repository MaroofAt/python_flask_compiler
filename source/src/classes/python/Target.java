package classes.python;

import java.util.ArrayList;

public class Target {
    private Target_Atom target_atom;
    private ArrayList<Target_Postfix> target_postfix_arraylist; //nullable

    public Target() {
        this.target_atom = new Target_Atom();
        this.target_postfix_arraylist = null;
    }

    public Target_Atom getTarget_atom() {
        return target_atom;
    }
    public void setTarget_atom(Target_Atom target_atom) {
        this.target_atom = target_atom;
    }
    public ArrayList<Target_Postfix> getTarget_postfix_arraylist() {
        if(target_postfix_arraylist == null){
            this.target_postfix_arraylist = new ArrayList<>();
        }
        return target_postfix_arraylist;
    }
    public void setTarget_postfix_arraylist(ArrayList<Target_Postfix> target_postfix_arraylist) {
        this.target_postfix_arraylist = target_postfix_arraylist;
    }

    public void add_to_target_postfix_arraylist(Target_Postfix ex){
        if(target_postfix_arraylist == null){
            this.target_postfix_arraylist = new ArrayList<>();
        }
        this.target_postfix_arraylist.add(ex);
    }

    @Override
    public String toString() {
        String result = "\nTarget{" +
                "\ntarget_atom=" + target_atom;
        if(target_postfix_arraylist != null) {
            result += "\n, target_postfix_arraylist=" + target_postfix_arraylist;
        }
        result += "\n}";
        return result;
    }
}
