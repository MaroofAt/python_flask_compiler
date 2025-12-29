package classes.python;

import java.util.ArrayList;

public class Try_Stmt extends Compound_Stmt{
    private Suite suite;
    private ArrayList<Except_Clause> except_clause_arraylist;
    private Else_Clause else_clause; //nullable
    private Finally_Clause finally_clause; //nullable

    public Try_Stmt() {
        this.suite = new Suite();
        this.except_clause_arraylist = new ArrayList<>();
        this.else_clause = null;
        this.finally_clause = null;
    }

    public Suite getSuite() {
        return suite;
    }
    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public ArrayList<Except_Clause> getExcept_clause_arraylist() {
        return except_clause_arraylist;
    }
    public void setExcept_clause_arraylist(ArrayList<Except_Clause> except_clause_arraylist) {
        this.except_clause_arraylist = except_clause_arraylist;
    }

    public Else_Clause getElse_clause() {
        if(else_clause == null){
            this.else_clause = new Else_Clause();
        }
        return else_clause;
    }
    public void setElse_clause(Else_Clause else_clause) {
        this.else_clause = else_clause;
    }

    public Finally_Clause getFinally_clause() {
        if(finally_clause == null){
            this.finally_clause = new Finally_Clause();
        }
        return finally_clause;
    }
    public void setFinally_clause(Finally_Clause finally_clause) {
        this.finally_clause = finally_clause;
    }

    @Override
    public String toString() {
        String result = "\nTry_Stmt{" +
                "\nsuite=" + suite +
                "\n, except_clause_arraylist=" + except_clause_arraylist;
        if(else_clause != null) {
            result += "\n, else_clause=" + else_clause;
        }
        if(finally_clause != null) {
            result += "\n, finally_clause=" + finally_clause;
        }
        result += "\n}";
        return result;
    }
}
