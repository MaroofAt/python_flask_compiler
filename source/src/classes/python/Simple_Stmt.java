package classes.python;

import java.util.ArrayList;

public class Simple_Stmt extends Statement{
    private ArrayList<Small_Stmt> small_stmt_arraylist;

    public Simple_Stmt() {
        this.small_stmt_arraylist = new ArrayList<>();
    }

    public ArrayList<Small_Stmt> getSmall_stmt_arraylist() {
        return small_stmt_arraylist;
    }

    public void setSmall_stmt_arraylist(ArrayList<Small_Stmt> small_stmt_arraylist) {
        this.small_stmt_arraylist = small_stmt_arraylist;
    }

    public void add_to_small_stmt_arraylist(Small_Stmt small_stmt){
        this.small_stmt_arraylist.add(small_stmt);
    }

    @Override
    public String toString() {
        return "\nSimple_Stmt{" +
                "\nsmall_stmt_arraylist=" + small_stmt_arraylist +
                "\n}";
    }
}
