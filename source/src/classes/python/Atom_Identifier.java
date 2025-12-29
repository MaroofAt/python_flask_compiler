package classes.python;

public class Atom_Identifier extends Atom{
    private Identifier identifier;

    public Atom_Identifier() {
        this.identifier = new Identifier();
    }

    public Identifier getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "\nAtom_Identifier{" +
                "\nidentifier=" + identifier +
                "\n}";
    }
}
