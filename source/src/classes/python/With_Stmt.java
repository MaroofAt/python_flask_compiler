package classes.python;

import classes.with_arr_ex;

import java.util.ArrayList;

public class With_Stmt extends Compound_Stmt{
    private ArrayList<With_Item> with_item_arraylist;
    private Suite suite;

    public With_Stmt() {
        this.with_item_arraylist = new ArrayList<>();
        this.suite = new Suite();
    }

    public ArrayList<With_Item> getWith_item_arraylist() {
        return with_item_arraylist;
    }
    public void setWith_item_arraylist(ArrayList<With_Item> with_item_arraylist) {
        this.with_item_arraylist = with_item_arraylist;
    }
    public void add_to_with_item_arraylist(With_Item ex){
        this.with_item_arraylist.add(ex);
    }

    public Suite getSuite() {
        return suite;
    }
    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString() {
        return "\nWith_Stmt{" +
                "\nwith_item_arraylist=" + with_item_arraylist +
                "\n, suite=" + suite +
                "\n}";
    }
}
