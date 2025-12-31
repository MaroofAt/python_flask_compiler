package classes.python;

public class Import_From_Stmt extends Import_Stmt{
    private Import_From_Target import_from_target;
    private Import_Targets import_targets;

    public Import_From_Stmt() {
        this.import_from_target = new Import_From_Target();
        this.import_targets = new Import_Targets();
    }

    public Import_From_Target getImport_from_target() {
        return import_from_target;
    }
    public void setImport_from_target(Import_From_Target import_from_target) {
        this.import_from_target = import_from_target;
    }

    public Import_Targets getImport_targets() {
        return import_targets;
    }
    public void setImport_targets(Import_Targets import_targets) {
        this.import_targets = import_targets;
    }

    @Override
    public String toString() {
        return "\nImport_From_Stmt{" +
                "\nimport_from_target=" + import_from_target +
                "\n, import_targets=" + import_targets +
                "\n}";
    }
}
