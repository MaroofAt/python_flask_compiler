package classes.python;

import java.util.ArrayList;

public class Dict_Items {
    private ArrayList<Dict_Item> dict_item_arraylist;

    public Dict_Items() {
        this.dict_item_arraylist = new ArrayList<>();
    }

    public ArrayList<Dict_Item> getDict_item_arraylist() {
        return dict_item_arraylist;
    }
    public void setDict_item_arraylist(ArrayList<Dict_Item> dict_item_arraylist) {
        this.dict_item_arraylist = dict_item_arraylist;
    }

    public void add_to_dict_item_arraylist(Dict_Item ex){
        this.dict_item_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nDict_Items{" +
                "\ndict_item_arraylist=" + dict_item_arraylist +
                "\n}";
    }
}
