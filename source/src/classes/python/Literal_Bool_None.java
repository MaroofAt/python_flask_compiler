package classes.python;

public class Literal_Bool_None extends Atom_Literal{
    private String string;

    public Literal_Bool_None() {
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
        return "\nLiteral_Bool_None{" +
                "\nstring='" + string + '\'' +
                "\n}";
    }
}
