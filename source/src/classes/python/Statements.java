package classes.python;

import java.util.ArrayList;

public class Statements {
    ArrayList<Statement> statement_arraylist;
//    ArrayList<String> newlines_arraylist; //nullable

    public Statements() {
        this.statement_arraylist = new ArrayList<>();
//        this.newlines_arraylist = null;
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



//    public ArrayList<String> getNewlines_arraylist() {
//        if(newlines_arraylist == null){
//            this.newlines_arraylist = new ArrayList<>();
//        }
//        return newlines_arraylist;
//    }
//
//    public void setNewlines_arraylist(ArrayList<String> newlines_arraylist) {
//        this.newlines_arraylist = newlines_arraylist;
//    }
//
//    public void add_to_newlines_arraylist(String newline){
//        if(newlines_arraylist == null){
//            this.newlines_arraylist = new ArrayList<>();
//        }
//        this.newlines_arraylist.add(newline);
//    }

    @Override
    public String toString() {
        String result = "\nStatements{" +
                "\nstatement_arraylist=" + statement_arraylist;
//        if(newlines_arraylist != null){
//            result += "\n, newlines_arraylist="+ newlines_arraylist;
//        }
        result += "\n}";
        return result;
    }

}
