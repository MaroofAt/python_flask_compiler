package classes.python;

public class Set_Literal extends Atom_Enclosure{
    private Set_Items set_items;

    public Set_Literal() {
        this.set_items = new Set_Items();
    }

    public Set_Items getSet_items() {
        return set_items;
    }
    public void setSet_items(Set_Items set_items) {
        this.set_items = set_items;
    }

    @Override
    public String toString() {
        return "\nSet_Literal{" +
                "\nset_items=" + set_items +
                "\n}";
    }
}
