package classes.python;

public class Literal_String extends Atom_Literal{
    private String string;

    public Literal_String() {
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
        return "\nLiteral_String{" +
                "\nstring='" + string + '\'' +
                "\n}";
    }
}
