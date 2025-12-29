package classes.python;

public class Import_From_Target_Dots extends Import_From_Target{
    private String dots;

    public Import_From_Target_Dots() {
        this.dots = new String();
    }
    public String getDots() {
        return dots;
    }
    public void setDots(String dots) {
        this.dots = dots;
    }

    @Override
    public String toString() {
        return "\nImport_From_Target_Dots{" +
                "\ndots='" + dots + '\'' +
                "\n}";
    }
}
