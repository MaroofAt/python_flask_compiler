package classes.python;


public class Class_Def extends Compound_Stmt{
    private Decorators decorators; //nullable
    private Identifier identifier;
    private Inheritance inheritance; //nullable
    private Suite suite;

    public Class_Def() {
        this.decorators = null;
        this.identifier = new Identifier();
        this.inheritance = null;
        this.suite = new Suite();
    }

    public Decorators getDecorators() {
        if(decorators == null){
            this.decorators = new Decorators();
        }
        return decorators;
    }
    public void setDecorators(Decorators decorators) {
        this.decorators = decorators;
    }

    public Identifier getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Inheritance getInheritance() {
        if(inheritance == null){
            this.inheritance = new Inheritance();
        }
        return inheritance;
    }
    public void setInheritance(Inheritance inheritance) {
        this.inheritance = inheritance;
    }

    public Suite getSuite() {
        return suite;
    }
    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString() {
        String result = "\nClass_Def{";
        if(decorators != null) {
            result += "\ndecorators=" + decorators;
        }

        result += "\n, identifier=" + identifier;

        if(inheritance != null) {
            result += "\n, inheritance=" + inheritance;
        }

        result += "\n, suite=" + suite;
        result += "\n}";
        return result;
    }
}
