package classes.python;

import java.util.ArrayList;

public class Target_List {
    private ArrayList<Target> target_arraylist;

    public Target_List() {
        this.target_arraylist = new ArrayList<>();
    }

    public ArrayList<Target> getTarget_arraylist() {
        return target_arraylist;
    }
    public void setTarget_arraylist(ArrayList<Target> target_arraylist) {
        this.target_arraylist = target_arraylist;
    }

    @Override
    public String toString() {
        return "\nTarget_List{" +
                "\ntarget_arraylist=" + target_arraylist +
                "\n}";
    }
}
