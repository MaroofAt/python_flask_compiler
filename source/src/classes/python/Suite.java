package classes.python;

public class Suite {
    private Simple_Stmt simple_stmt; //nullable
    private Statements statements; //nullable

    public Suite() {
        this.simple_stmt = null;
        this.statements = null;
    }

    public Simple_Stmt getSimple_stmt() {
        if(simple_stmt == null){
            this.simple_stmt = new Simple_Stmt();
        }
        return simple_stmt;
    }
    public void setSimple_stmt(Simple_Stmt simple_stmt) {
        this.simple_stmt = simple_stmt;
    }

    public Statements getStatements() {
        if(statements == null){
            this.statements = new Statements();
        }
        return statements;
    }
    public void setStatements(Statements statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        String result = "\nSuite{";
        if(simple_stmt != null) {
            result += "\nsimple_stmt=" + simple_stmt;
        }
        if(statements != null) {
            result += "\n, statements=" + statements;
        }
        result += "\n}";
        return result;
    }
}
