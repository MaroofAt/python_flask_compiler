package classes.python;

public class Target_Postfix_Attribute_Ref extends Target_Postfix{
    private Attribute_Ref attribute_ref;

    public Target_Postfix_Attribute_Ref() {
        this.attribute_ref = new Attribute_Ref();
    }

    public Attribute_Ref getAttribute_ref() {
        return attribute_ref;
    }
    public void setAttribute_ref(Attribute_Ref attribute_ref) {
        this.attribute_ref = attribute_ref;
    }

    @Override
    public String toString() {
        return "\nTarget_Postfix_Attribute_Ref{" +
                "\nattribute_ref=" + attribute_ref +
                "\n}";
    }
}
