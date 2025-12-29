package classes.python;

import java.util.ArrayList;

public class Statements {
    ArrayList<Statement> statement_arraylist;

    public Statements() {
        this.statement_arraylist = new ArrayList<>();
    }

    public ArrayList<Statement> getStatement_arraylist() {
        return statement_arraylist;
    }

    public void setStatement_arraylist(ArrayList<Statement> statement_arraylist) {
        this.statement_arraylist = statement_arraylist;
    }

    public void add_to_statement_arraylist(Statement statement){
        this.statement_arraylist.add(statement);
    }

    @Override
    public String toString() {
        return "\nStatements{" +
                "\nstatement_arraylist=" + statement_arraylist +
                "\n}";
    }

}
