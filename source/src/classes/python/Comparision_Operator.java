package classes.python;

public class Comparision_Operator {
    private String string;

    public Comparision_Operator() {
        this.string = new String();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "\nComparision_Operator{" +
                "\nstring='" + string + '\'' +
                "\n}";
    }
}
