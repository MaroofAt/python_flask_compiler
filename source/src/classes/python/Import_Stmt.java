package classes.python;

public class Import_Stmt extends Small_Stmt{
    private Import_Targets import_targets;

    public Import_Stmt() {
        this.import_targets = new Import_Targets();
    }

    public Import_Targets getImport_targets() {
        return import_targets;
    }
    public void setImport_targets(Import_Targets import_targets) {
        this.import_targets = import_targets;
    }

    @Override
    public String toString() {
        return "\nImport_Stmt{" +
                "\nimport_targets=" + import_targets +
                "\n}";
    }
}
