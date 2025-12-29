package classes.python;


import java.util.ArrayList;

public class Dotted_Name {
    private ArrayList<Identifier> identifier_arraylist;

    public Dotted_Name() {
        this.identifier_arraylist = new ArrayList<>();
    }

    public ArrayList<Identifier> getIdentifier_arraylist() {
        return identifier_arraylist;
    }
    public void setIdentifier_arraylist(ArrayList<Identifier> identifier_arraylist) {
        this.identifier_arraylist = identifier_arraylist;
    }
    public void add_to_identifier_arraylist(Identifier ex){
        this.identifier_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nDotted_Name{" +
                "\nidentifier_arraylist=" + identifier_arraylist +
                "\n}";
    }
}
