package classes.python;

public class Except_Clause {
    private Except_Expression except_expression;
    private Identifier identifier; //nullable
    private Suite suite;

    public Except_Clause() {
        this.except_expression = new Except_Expression();
        this.identifier = null;
        this.suite = new Suite();
    }

    public Except_Expression getExcept_expression() {
        return except_expression;
    }
    public void setExcept_expression(Except_Expression except_expression) {
        this.except_expression = except_expression;
    }

    public Identifier getIdentifier() {
        if(identifier == null){
            this.identifier = new Identifier();
        }
        return identifier;
    }
    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Suite getSuite() {
        return suite;
    }
    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString() {
        return "\nExcept_Clause{" +
                "\nexcept_expression=" + except_expression +
                "\n, identifier=" + identifier +
                "\n, suite=" + suite +
                "\n}";
    }
}
