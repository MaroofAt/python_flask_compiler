package classes.python;

public class Attribute_Ref extends Postfix{
    private Identifier identifier;

    public Attribute_Ref() {
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
        return "\nAttribute_Ref{" +
                "\nidentifier=" + identifier +
                "\n}";
    }
}
