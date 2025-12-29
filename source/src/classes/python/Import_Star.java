package classes.python;

public class Import_Star extends Import_Target{
    private String star;

    public Import_Star() {
        this.star = "*";
    }

    public String getStar() {
        return star;
    }
    public void setStar(String star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "\nImport_Star{" +
                "\nstar='" + star + '\'' +
                "\n}";
    }
}
