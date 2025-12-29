package classes.python;


import java.util.ArrayList;

public class Import_Targets {
    private ArrayList<Import_Target> import_target_arraylist;

    public Import_Targets() {
        this.import_target_arraylist = new ArrayList<>();
    }

    public ArrayList<Import_Target> getImport_target_arraylist() {
        return import_target_arraylist;
    }
    public void setImport_target_arraylist(ArrayList<Import_Target> import_target_arraylist) {
        this.import_target_arraylist = import_target_arraylist;
    }

    public void add_to_import_target_arraylist(Import_Target ex){
        this.import_target_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nImport_Targets{" +
                "\nimport_target_arraylist=" + import_target_arraylist +
                "\n}";
    }
}
