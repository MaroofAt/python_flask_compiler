package classes.python;

public class Literal_Number extends Atom_Literal{
    private Number number;

    public Literal_Number() {
        this.number = new Number();
    }

    public Number getNumber() {
        return number;
    }
    public void setNumber(Number number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nLiteral_Number{" +
                "\nnumber=" + number +
                "\n}";
    }
}
