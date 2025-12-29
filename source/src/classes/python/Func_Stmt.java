package classes.python;

public class Func_Stmt extends Compound_Stmt{
    private Decorators decorators; //nullable
    private Parameters_List parameters_list; //nullable
    private Identifier identifier; //nullable
    private Suite suite;

    public Func_Stmt() {
        this.decorators = null;
        this.parameters_list = null;
        this.identifier = null;
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

    public Parameters_List getParameters_list() {
        if(parameters_list == null){
            this.parameters_list = new Parameters_List();
        }
        return parameters_list;
    }
    public void setParameters_list(Parameters_List parameters_list) {
        this.parameters_list = parameters_list;
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
        if(suite == null){
            this.suite = new Suite();
        }
        return suite;
    }
    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString() {
        String result = "\nFunc_Stmt{";
        if(decorators != null) {
            result += "\ndecorators=" + decorators;
        }
        if(parameters_list != null) {
            result += "\n, parameters_list=" + parameters_list;
        }
        if(identifier != null) {
            result += "\n, identifier=" + identifier;
        }
        result += "\n, suite=" + suite;
        result += "\n}";
        return result;
    }
}
