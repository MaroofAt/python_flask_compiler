package classes.python;

public class Dict_Literal extends Atom_Enclosure{
    private Dict_Items dict_items;

    public Dict_Literal() {
        this.dict_items = new Dict_Items();
    }

    public Dict_Items getDict_items() {
        return dict_items;
    }

    public void setDict_items(Dict_Items dict_items) {
        this.dict_items = dict_items;
    }

    @Override
    public String toString() {
        return "\nDict_Literal{" +
                "\ndict_items=" + dict_items +
                "\n}";
    }
}
