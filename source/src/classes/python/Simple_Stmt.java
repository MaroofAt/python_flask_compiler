package classes.python;

import java.util.ArrayList;

public class Simple_Stmt extends Statement{
    private ArrayList<Small_Stmt> small_stmt_arraylist; //nullable
    public String newline; //nullable

    public Simple_Stmt() {
//        this.small_stmt_arraylist = new ArrayList<>();
        this.small_stmt_arraylist = null;
        newline = null;
    }

    public ArrayList<Small_Stmt> getSmall_stmt_arraylist() {
        if(small_stmt_arraylist == null){
            this.small_stmt_arraylist = new ArrayList<>();
        }
        return small_stmt_arraylist;
    }

    public void setSmall_stmt_arraylist(ArrayList<Small_Stmt> small_stmt_arraylist) {
        this.small_stmt_arraylist = small_stmt_arraylist;
    }

    public void add_to_small_stmt_arraylist(Small_Stmt small_stmt){
        if(small_stmt_arraylist == null){
            this.small_stmt_arraylist = new ArrayList<>();
        }
        this.small_stmt_arraylist.add(small_stmt);
    }

    public String getNewline() {
        return newline;
    }
    public void setNewline(String newline) {
        this.newline = newline;
    }

    @Override
    public String toString() {
        String result = "\nSimple_Stmt{";
        if(this.small_stmt_arraylist != null){
            result += "\nsmall_stmt_arraylist=" + small_stmt_arraylist;
        }
        if(this.newline != null){
            result += "\nnewline="+ newline;
        }
        result += "\n}";
        return result;
    }
}
