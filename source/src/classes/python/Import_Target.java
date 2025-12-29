package classes.python;

import java.util.ArrayList;

public class Import_Target {
    private ArrayList<Identifier> identifier_arraylist;

    public Import_Target() {
        this.identifier_arraylist = new ArrayList<>();
    }

    public ArrayList<Identifier> getIdentifier_arraylist() {
        return identifier_arraylist;
    }
    public void setIdentifier_arraylist(ArrayList<Identifier> identifier_arraylist) {
        this.identifier_arraylist = identifier_arraylist;
    }

    @Override
    public String toString() {
        return "\nImport_Target{" +
                "\nidentifier_arraylist=" + identifier_arraylist +
                "\n}";
    }
}
